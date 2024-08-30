package com.democracy.electoral_court.infrastructure.jni;


import org.springframework.stereotype.Component;

@Component
public class CedulaJni {

    static {
       // System.setProperty("java.library.path", "/home/raul927/DESAROLLO/bin");
        System.out.print("LIBRARY_PATH: "+System.getProperty("java.library.path")+" #");
        System.loadLibrary("ElectoralCourtCedula");
    }
    public native int controloCedula(int cedula);
}
