package ar.edu.unahur.obj2.cloud.misExceptiones;

public class LimiteDeOverprovisioningException extends RuntimeException {

    public LimiteDeOverprovisioningException() {
        super("Se admite un sobre-compromiso de recursos (overprovisioning) en el clúster de hasta -200 vCPUs.");
    }
    
}
