package co.com.delibolis.products.jni;


public class JniExample {

    static {
        System.out.print("libraryPath: "+System.getProperty("java.library.path")+" .");
        System.loadLibrary("ControlCedulaC");
    }
    public native int controloCedula(int cedula);
}
