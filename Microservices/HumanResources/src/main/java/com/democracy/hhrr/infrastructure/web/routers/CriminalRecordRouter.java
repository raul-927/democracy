package com.democracy.hhrr.infrastructure.web.routers;

import com.democracy.hhrr.infrastructure.constants.RouterConstant;
import com.democracy.hhrr.infrastructure.web.handlers.CriminalRecordHandler;
import com.democracy.hhrr.infrastructure.web.handlers.DepartmentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CriminalRecordRouter {
    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String CRIMINAL_RECORD = RouterConstant.CRIMINAL_RECORD;
    private static final String PATH_SELECT_ALL =RouterConstant.PATH_SELECT_ALL;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    //private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String PATH_COUNT=RouterConstant.PATH_COUNT;

    @Bean
    public RouterFunction<ServerResponse> routerCriminalRecord(CriminalRecordHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + CRIMINAL_RECORD + PATH_SELECT), handler::selectCriminalRecord)
                .andRoute(
                        POST(PATH_MAIN + CRIMINAL_RECORD +  PATH_SAVE), handler::createCriminalRecord)
                //.andRoute(
                //        POST(PATH_MAIN + DEPARTMENT_PATH +PATH_INSERT), handler::createMultipleDepartment)
                .andRoute(
                        PUT(PATH_MAIN + CRIMINAL_RECORD +  PATH_UPDATE), handler::updateCriminalRecord)
                .andRoute(
                        GET(PATH_MAIN + CRIMINAL_RECORD +  PATH_COUNT), handler::selectCount)
                .andRoute(
                        GET(PATH_MAIN + CRIMINAL_RECORD + PATH_SELECT_ALL), handler::selectAllCriminalRecords);
    }
}
