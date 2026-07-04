package ar.edu.unahur.obj2.cloud.misExceptiones;

public class ValoresInvalidosException extends RuntimeException {

    public ValoresInvalidosException() {
        super("No se puede instanciar un valor menor o igual a 0");
    }
    
}
