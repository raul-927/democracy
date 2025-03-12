package com.democracy.application.services;

import com.democracy.domain.models.Department;
import com.democracy.domain.models.Order;
import com.democracy.infrastructure.events.OrderEvents;
import com.democracy.infrastructure.satates.OrderStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private StateMachineFactory<OrderStates, OrderEvents> machineFactory;
    private StateMachine<OrderStates, OrderEvents> stateMachine;

    //@Autowired
    //DepartmentFeingClient feingClient;


    private final String BORED_API = "http://localhost:8082/humanresources/department/select-count";

    @Override
    public Order newOrder(Order order) {
        initOrderSaga();
        validateOrder(order);
        payOrder();
        shipOrder();
        completeOrder();
        return order;
    }
    @Override
    public void initOrderSaga(){
        System.out.println("Initializing order saga");
        stateMachine = machineFactory.getStateMachine();
        stateMachine.startReactively().subscribe();
        System.out.println("Final state initOrderSaga: "+stateMachine.getState().getId());
    }
    @Override
    public void validateOrder(Order order) {
        System.out.println("Validating order");
        Flux<Department> returnDepartments = getDepartment();
        returnDepartments.subscribe(de-> System.out.println("COUNT: "+de.getDepartmentName()));
        List<Department> departments = getDepartmentbyRestTemplate();
        departments.forEach(dep->{
            System.out.println("DEPARTMENT_ID: " +dep.getDepartmentId());
            System.out.println("DEPARTMENT_NAME: "+dep.getDepartmentName());
        });

        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.VALIDATE)
                                .setHeader("order",order).build()))
                .subscribe(result -> System.out.println("RESULT validateOrder: "+result.getResultType()));
        System.out.println("Final state validateOrder: "+stateMachine.getState().getId());
    }
    @Override
    public void payOrder() {
        System.out.println("Paying order...");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.PAY).build()))
                .subscribe(result -> System.out.println("RESULT payOrder: "+result.getResultType()));
        System.out.println("Final state payOrder: "+stateMachine.getState().getId());
    }
    @Override
    public void shipOrder() {
        System.out.println("Shipping order...");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.SHIP).build()))
                .subscribe(result -> System.out.println("RESULT shipOrder: "+result.getResultType()));
        System.out.println("Final state: shipOrder "+stateMachine.getState().getId());
    }
    @Override
    public void completeOrder() {
        System.out.println("Completing order.");
        stateMachine.sendEvent(Mono.just(
                        MessageBuilder.withPayload(OrderEvents.COMPLETE).build()))
                .subscribe(result -> System.out.println("RESULT completeOrder: "+result.getResultType()));
        System.out.println("Final state completeOrder: "+stateMachine.getState().getId());
        stopOrderSaga();
    }
    @Override
    public void stopOrderSaga(){
        System.out.println("Stopping saga...");
        System.out.println("------------------------");
        stateMachine.stopReactively().subscribe();
    }

    //@GetMapping(value = "/select-count", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Department> getDepartment() {
        System.out.println("ENTRA");
        RestTemplate restTemplate = new RestTemplate();

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:8082").build();
       /* Mono<Department> entityMono = webClient.get()
                .uri("/humanresources/department/select-all")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(Department.class);
                    }else{

                    }
                    return null;
                });*/
        return webClient.get()
                .uri("/humanresources/department/select-all")
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToFlux(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToFlux(Department.class);
                    }else{
                        System.out.println("STATUS: "+response.statusCode());
                        return response.bodyToFlux(Department.class);
                    }
                });
    }

    private List<Department> getDepartmentbyRestTemplate(){
        String token = obtainToken();
        System.out.println("TOKEN: "+token);
        ParameterizedTypeReference<List<Department>> typeRef =
                new ParameterizedTypeReference<List<Department>>() {};
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGY3E0VHgzM0JlWmd4cVVuUWIwZmZfRm1ENWFnZzl1MmtVYWIzbzVmMUt3In0.eyJleHAiOjE3NDE4MjAyMjMsImlhdCI6MTc0MTgxOTkyMywianRpIjoiYmIxMzY5NTAtYWQ3ZS00M2Y1LWJkNWMtMWM1NDI5MGFiOGQ5IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MTgxL3JlYWxtcy9kZW1vY3JhY3lfcmVhbG0iLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiMDI0YTUyZDctNzljNy00ZTU5LWI0YjQtOWNjZDYwMzE5ZGZmIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiZGVtb2NyYWN5X2NsaWVudCIsInNpZCI6IjRhODY3OGJlLTdhYWQtNDY4Yi05YjFiLTYzOWRjNjEyMzRmMSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtZGVtb2NyYWN5X3JlYWxtIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJuYW1lIjoiUmF1bCBoZXJuYW5kZXoiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJyYXJhaGVyaGVyOTI3NCIsImdpdmVuX25hbWUiOiJSYXVsIiwiZmFtaWx5X25hbWUiOiJoZXJuYW5kZXoiLCJlbWFpbCI6InJhcmFoZXJoZXI5Mjc0QGdtYWlsLmNvbSJ9.PNnt-OVQPqW2yxhBkk3yDvQDlmNcxaeD3ntIvxx3iW0CiYSPNBHreXTdNiHnJmqIo1okcSE6kR2hwT5HC9yh-9KMyHnDpPsT_QIXBEF5nzdJ4ydMqMSqqQ4jwKcAoXRDulx0L2hxOtD2s_NtQpc-lJ1L41uEERlbZj0qJgpaeKRhqpbSg91MA58ahbPrkWaV6Kmlj6tqRuyGlrMSdzA61uK9vByGYcBnSwdtZZewblHPSFu7jHv2aV4iuTOaNw1uk2N5hQ3VbguQUJNZPlmt63fO3LodVvFvVutnQm2UeCPS6_eYqku0U8FQiGd0BegH1WGKXMKoewtZByGZJKso6w");
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8082/humanresources/department/select-all";
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<List<Department>> response
                = restTemplate.exchange(resourceUrl, HttpMethod.GET, entity, typeRef);
        return response.getBody();
    }
    private String obtainToken(){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        //headers.add("PRIVATE-TOKEN", "xyz");

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id","democracy_client");
        map.add("client_secret","YYcdVQO1lB9F5IjxjN6ljHueBWhZz1aZ");
        map.add("grant_type","password");
        map.add("username","raraherher9274");
        map.add("password","raraherher9274");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

        ResponseEntity<String> response =
                restTemplate.exchange("http://localhost:8181/realms/democracy_realm/protocol/openid-connect/token",
                        HttpMethod.POST,
                        entity,
                        String.class);
        return response.getBody();
    }
}