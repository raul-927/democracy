package com.democracy.feingtarget.domain.enums;

import lombok.Getter;

@Getter
public enum ProductType {

    RAW_MATERIAL(1, "MATERIA_PRIMA"),
    FINAL_PRODUCT(2,"PRODUCTO_FINAL");


    private final int    id;
    private final String description;


    private ProductType(int id, String description){
        this.id = id;
        this.description = description;
    }
}
