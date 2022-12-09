package com.democracy.person.enumerator;

public enum DocumentTypeEnum {
    CC(1, "Cedula ciudadania"),
    CE(2, "Cedula Extranjeria");

    private int id;
    private String nombre;

    private DocumentTypeEnum(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
