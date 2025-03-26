package com.democracy.hhrr.infrastructure.web.routers;


import com.democracy.hhrr.infrastructure.constants.RouterConstant;
import com.democracy.hhrr.infrastructure.web.handlers.DepartmentHandler;
import com.democracy.hhrr.infrastructure.web.handlers.InvestigationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class InvestigationRouter {

    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String INVESTIGATION = RouterConstant.INVESTIGATION;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;

    @Bean
    public RouterFunction<ServerResponse> routerInvestigation(InvestigationHandler handler){
        return RouterFunctions
                .route(
                        GET(PATH_MAIN + INVESTIGATION + PATH_SELECT), handler::selectInvestigation);

    }
}
