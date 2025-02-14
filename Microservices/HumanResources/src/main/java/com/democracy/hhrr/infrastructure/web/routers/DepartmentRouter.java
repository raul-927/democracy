package com.democracy.hhrr.infrastructure.web.routers;

import com.democracy.hhrr.infrastructure.web.handlers.DepartmentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class DepartmentRouter {
    private static final String PATH_MAIN = "/humanresources";
    private static final String DEPARTMENT_PATH = "/department";
    private static final String PATH_SELECT_ALL ="/select-all";
    private static final String PATH_SELECT = "/select";
    private static final String PATH_SAVE = "/save";
    private static final String PATH_INSERT = "/insert";
    private static final String PATH_UPDATE = "/update";
    private static final String PATH_COUNT="/select-count";


    @Bean
    public RouterFunction<ServerResponse> routerDepartment(DepartmentHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + DEPARTMENT_PATH + PATH_SELECT), handler::selectDepartment)
                .andRoute(
                        POST(PATH_MAIN + DEPARTMENT_PATH +  PATH_SAVE), handler::createDepartment)
                .andRoute(
                        POST(PATH_MAIN + DEPARTMENT_PATH +PATH_INSERT), handler::createMultipleDepartment)
                .andRoute(
                        PUT(PATH_MAIN + DEPARTMENT_PATH +  PATH_UPDATE), handler::updateDepartment)
                .andRoute(
                        GET(PATH_MAIN + DEPARTMENT_PATH +  PATH_COUNT), handler::selectCount)
                .andRoute(
                        GET(PATH_MAIN + DEPARTMENT_PATH + PATH_SELECT_ALL), handler::selectAllDepartment);
    }


}
