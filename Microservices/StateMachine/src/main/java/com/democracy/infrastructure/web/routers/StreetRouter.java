package com.democracy.infrastructure.web.routers;


import com.democracy.infrastructure.constants.RouterConstant;
import com.democracy.infrastructure.web.handlers.StreetHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

//@Configuration
public class StreetRouter {
    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String STREET_PATH = RouterConstant.CALCULATE_INVOICES;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String PATH_COUNT= RouterConstant.PATH_COUNT;

    //@Bean
    public RouterFunction<ServerResponse> routerStreet(StreetHandler handler){
        return RouterFunctions
                .route(
                        GET(PATH_MAIN + STREET_PATH + PATH_SELECT), handler::selectStreet);
    }
}
