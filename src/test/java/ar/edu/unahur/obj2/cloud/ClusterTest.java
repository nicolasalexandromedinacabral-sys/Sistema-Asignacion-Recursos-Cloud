package ar.edu.unahur.obj2.cloud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.naming.LimitExceededException;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.misExceptiones.LimiteDeOverprovisioningException;

public class ClusterTest {
    @Test
    public void testAsignarCapacidad() {
        Cluster cluster = new Cluster("C1", 100);
        cluster.asignarCapacidad(50);
        assertEquals(150, cluster.getvCPUs());
    }

    @Test
    public void testLiberarCapacidad() {
        Cluster cluster = new Cluster("C1", 100);
        cluster.liberarCapacidad(50);
        assertEquals(50, cluster.getvCPUs());
    }

    @Test
    public void testLiberarCapacidadSuperandoLimite() {
        Cluster cluster = new Cluster("C1", 100);
        
        assertThrows(LimiteDeOverprovisioningException.class,()-> cluster.liberarCapacidad(1000));
    }

}
