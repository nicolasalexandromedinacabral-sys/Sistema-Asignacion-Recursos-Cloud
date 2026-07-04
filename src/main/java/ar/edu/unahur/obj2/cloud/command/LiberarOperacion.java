package ar.edu.unahur.obj2.cloud.command;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.misExceptiones.ValoresInvalidosException;

public class LiberarOperacion implements Operacion {
    private Cluster cluster;
    private Integer cantidadvCPUs;
    
    public LiberarOperacion(Cluster cluster, Integer cantidadvCPUs) {
        if (cantidadvCPUs <=0) {
            throw new ValoresInvalidosException();
        }
        this.cluster = cluster;
        this.cantidadvCPUs = cantidadvCPUs;
    }

    @Override
    public void execute() {
        cluster.liberarCapacidad(cantidadvCPUs);
    }

    @Override
    public void undo() {
        cluster.asignarCapacidad(cantidadvCPUs);
    }

}
