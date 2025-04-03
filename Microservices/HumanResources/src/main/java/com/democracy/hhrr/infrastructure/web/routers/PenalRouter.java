package com.democracy.hhrr.infrastructure.web.routers;

import com.democracy.hhrr.infrastructure.constants.RouterConstant;
import com.democracy.hhrr.infrastructure.web.handlers.PenalHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PenalRouter {

    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String PENAL = RouterConstant.PENAL;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String DELETE= RouterConstant.DELETE;



    @Bean
    public RouterFunction<ServerResponse> routerPenal(PenalHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + PENAL + PATH_SELECT), handler::selectPenal)
                .andRoute(
                        POST(PATH_MAIN + PENAL +  PATH_SAVE), handler::createPenal)
                .andRoute(
                       POST(PATH_MAIN + PENAL +PATH_INSERT), handler::createMultiplePenals)
                .andRoute(
                        PUT(PATH_MAIN + PENAL +  PATH_UPDATE), handler::updatePenal)
                .andRoute(
                        DELETE(PATH_MAIN + PENAL +  DELETE), handler::selectCount);
    }
}
