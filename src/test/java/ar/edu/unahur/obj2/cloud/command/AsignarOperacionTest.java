package ar.edu.unahur.obj2.cloud.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.misExceptiones.ValoresInvalidosException;

public class AsignarOperacionTest {
    @Test
    void testExecute() {
        Cluster cluster = new Cluster("C1", 100);
        AsignarOperacion asignarOperacion = new AsignarOperacion(cluster, 50);

        asignarOperacion.execute();

        assertEquals(150, cluster.getvCPUs());
    }

    @Test
    void testUndo() {
        Cluster cluster = new Cluster("C1", 100);
        AsignarOperacion asignarOperacion = new AsignarOperacion(cluster, 50);

        asignarOperacion.execute();

        assertEquals(150, cluster.getvCPUs());

        asignarOperacion.undo();
        assertEquals(100, cluster.getvCPUs());

    }

    @Test
    void testValoresInvalidos(){
        Cluster cluster = new Cluster("C1", 100);

        assertThrows(ValoresInvalidosException.class, () -> new AsignarOperacion(cluster, 0));
        
        assertThrows(ValoresInvalidosException.class, () -> new AsignarOperacion(cluster, -10));

    }
}
