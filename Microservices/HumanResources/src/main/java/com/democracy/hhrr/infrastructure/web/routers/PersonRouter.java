package com.democracy.hhrr.infrastructure.web.routers;

import com.democracy.hhrr.infrastructure.constants.RouterConstant;
import com.democracy.hhrr.infrastructure.web.handlers.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;

@Configuration
public class PersonRouter {

    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String PERSON = RouterConstant.PERSON;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String DELETE= RouterConstant.DELETE;


   @Bean
    public RouterFunction<ServerResponse> routerPerson(PersonHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + PERSON +  PATH_SAVE), handler::createPerson)
                .andRoute(
                         PUT(PATH_MAIN + PERSON + PATH_UPDATE), handler::updatePerson);

    }
}
