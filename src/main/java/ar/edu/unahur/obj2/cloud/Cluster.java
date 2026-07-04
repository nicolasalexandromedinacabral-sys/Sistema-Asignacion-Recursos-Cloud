package ar.edu.unahur.obj2.cloud;

import ar.edu.unahur.obj2.cloud.misExceptiones.LimiteDeOverprovisioningException;

public class Cluster {
    private String idCluster;
    private Integer vCPUs;

    public Cluster(String idCluster, Integer vCPUs) {
        this.idCluster = idCluster;
        this.vCPUs = vCPUs;
    }

    public Integer getvCPUs() {
        return vCPUs;
    }

    public void asignarCapacidad(Integer unvCPUs){
        vCPUs += unvCPUs;
    }

    public void liberarCapacidad(Integer unvCPUs){
        vCPUs -= unvCPUs;
        if (vCPUs < -200){
            throw new LimiteDeOverprovisioningException();
        }
    }

}
