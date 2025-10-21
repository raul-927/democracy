package com.democracy.electoral_court.infrastructure.web.routers;

import com.democracy.electoral_court.infrastructure.constants.RouterConstant;
import com.democracy.electoral_court.infrastructure.web.handlers.InvestigationHandler;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

//@Configuration
public class InvestigationRouter {

    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String INVESTIGATION = RouterConstant.INVESTIGATION_PATH;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String DELETE= RouterConstant.DELETE;


    //@Bean
    public RouterFunction<ServerResponse> routerPerson(InvestigationHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + INVESTIGATION + PATH_SELECT), handler::createInvestigation)
                .andRoute(
                        POST(PATH_MAIN + INVESTIGATION +  PATH_INSERT), handler::selectInvestigation);
    }
}
