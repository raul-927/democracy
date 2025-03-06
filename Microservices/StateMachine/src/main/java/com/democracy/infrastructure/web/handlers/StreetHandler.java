package com.democracy.infrastructure.web.handlers;

import com.democracy.domain.models.Street;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

//@Component
//@Slf4j
public class StreetHandler {


    public Mono<ServerResponse> selectStreet(ServerRequest request){
        var obtainStreet = request.bodyToMono(Street.class);
        Street sendStreet  = new Street();
        obtainStreet.map( str ->{
            sendStreet.setStreetId(str.getStreetId());
            sendStreet.setStreetType(str.getStreetType());
            sendStreet.setStreetName(str.getStreetName());
            return sendStreet;
        });
        return null;

    }


}