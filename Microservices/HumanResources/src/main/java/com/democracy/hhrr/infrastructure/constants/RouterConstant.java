package com.democracy.hhrr.infrastructure.constants;

import com.democracy.hhrr.infrastructure.repository.mybatis.r2dbc.support.StreetDynamicSqlSupport;

public class RouterConstant {
    //--------------------GENERIC PATH---------------------------------
    public static final String PATH_MAIN = "/humanresources";
    public static final String PATH_SELECT_ALL ="/select-all";
    public static final String PATH_SELECT = "/select";
    public static final String PATH_SAVE = "/save";
    public static final String PATH_INSERT = "/insert";
    public static final String PATH_UPDATE = "/update";
    public static final String PATH_COUNT="/select-count";
    public static final String DELETE ="/delete";
    //--------------------DOMAIN PATH---------------------------------------
    public static final String DEPARTMENT_PATH = "/department";
    public static final String STREET_PATH = "/street";
    public static final String INVESTIGATION ="/investigation";
    public static final String  PENAL = "/penal";
    public static final String PROFESSION = "/profession";
    public static final String PERSON ="/person";
    public static final String CRIMINAL_RECORD ="/criminalrecord";
    public static final String QUALIFICATION = "/qualification";
    public static final String DOCUMENT = "/document";
    public static final String INSTITUTE = "/institute";


}
