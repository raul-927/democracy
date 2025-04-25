package com.democracy.hhrr.infrastructure.web.routers;

import com.democracy.hhrr.infrastructure.constants.RouterConstant;
import com.democracy.hhrr.infrastructure.web.handlers.CriminalRecordHandler;
import com.democracy.hhrr.infrastructure.web.handlers.QualificationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class QualificationRouter {
    private static final String PATH_MAIN = RouterConstant.PATH_MAIN;
    private static final String QUALIFICATION = RouterConstant.QUALIFICATION;
    private static final String PATH_SELECT_ALL =RouterConstant.PATH_SELECT_ALL;
    private static final String PATH_SELECT = RouterConstant.PATH_SELECT;
    private static final String PATH_SAVE = RouterConstant.PATH_SAVE;
    //private static final String PATH_INSERT = RouterConstant.PATH_INSERT;
    private static final String PATH_UPDATE = RouterConstant.PATH_UPDATE;
    private static final String PATH_COUNT=RouterConstant.PATH_COUNT;

    @Bean
    public RouterFunction<ServerResponse> routerQualification(QualificationHandler handler){
        return RouterFunctions
                .route(
                        POST(PATH_MAIN + QUALIFICATION + PATH_SELECT), handler::selectQualification)
                .andRoute(
                        POST(PATH_MAIN + QUALIFICATION +  PATH_SAVE), handler::createQualification)
                //.andRoute(
                //        POST(PATH_MAIN + QUALIFICATION +PATH_INSERT), handler::createMultipleDepartment)
                .andRoute(
                        PUT(PATH_MAIN + QUALIFICATION +  PATH_UPDATE), handler::updateQualification)
                .andRoute(
                        GET(PATH_MAIN + QUALIFICATION +  PATH_COUNT), handler::selectCount)
                .andRoute(
                        GET(PATH_MAIN + QUALIFICATION + PATH_SELECT_ALL), handler::selectAllQualifications);
    }
}
