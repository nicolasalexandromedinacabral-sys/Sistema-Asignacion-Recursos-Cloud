package ar.edu.unahur.obj2.cloud.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.command.AsignarOperacion;
import ar.edu.unahur.obj2.cloud.command.LiberarOperacion;
import ar.edu.unahur.obj2.cloud.misExceptiones.LimiteDeOverprovisioningException;

public class PlanDeDesplieguesTest {
    @Test
    void testAddOperacion() {
        Cluster cluster = new Cluster("C1", 100);
        PlanDeDespliegues plan = new PlanDeDespliegues();

        plan.addOperacion(new AsignarOperacion(cluster, 20));
        plan.addOperacion(new LiberarOperacion(cluster, 10));

        plan.execute();

        assertEquals(110, cluster.getvCPUs());
    }

    @Test
    void testExcpetion() {
        Cluster cluster = new Cluster("C1", 100);
        PlanDeDespliegues plan = new PlanDeDespliegues();

        plan.addOperacion(new AsignarOperacion(cluster, 30));
        plan.addOperacion(new LiberarOperacion(cluster, 500));

        assertThrows(LimiteDeOverprovisioningException.class, plan::execute);
        
    }

     @Test
    void testUndoManualDelPlan() throws Exception {
        Cluster cluster = new Cluster("C3", 200);
        PlanDeDespliegues plan = new PlanDeDespliegues();

        plan.addOperacion(new AsignarOperacion(cluster, 40));
        plan.addOperacion(new LiberarOperacion(cluster, 10));

        plan.execute();
        assertEquals(230, cluster.getvCPUs());

        plan.undo(); // revertir manualmente
        assertEquals(200, cluster.getvCPUs());
    }

    @Test
    void testVaciar() {

    }
}
