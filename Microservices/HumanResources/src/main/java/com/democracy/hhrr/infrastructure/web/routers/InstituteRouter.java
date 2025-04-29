package com.democracy.hhrr.infrastructure.web.routers;

import com.democracy.hhrr.infrastructure.constants.RouterConstant;
import com.democracy.hhrr.infrastructure.web.handlers.InstituteHandler;
import com.democracy.hhrr.infrastructure.web.handlers.StreetHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class InstituteRouter {
    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String INSTITUTE = RouterConstant.INSTITUTE;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String PATH_COUNT= RouterConstant.PATH_COUNT;

    @Bean
    public RouterFunction<ServerResponse> routerInstitute(InstituteHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + INSTITUTE + PATH_SELECT), handler::selectInstitute)
                .andRoute(
                        POST(PATH_MAIN + INSTITUTE +  PATH_SAVE), handler::createInstitute)
                //.andRoute(
                 //       POST(PATH_MAIN + STREET_PATH +PATH_INSERT), handler::createMultipleStreet)
                .andRoute(
                        PUT(PATH_MAIN + INSTITUTE +  PATH_UPDATE), handler::updateInstitute)
                .andRoute(
                        GET(PATH_MAIN + INSTITUTE +  PATH_COUNT), handler::selectCount);
    }
}
