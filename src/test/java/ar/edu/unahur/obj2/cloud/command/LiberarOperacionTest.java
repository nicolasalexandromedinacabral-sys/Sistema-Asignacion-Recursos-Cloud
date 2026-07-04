package ar.edu.unahur.obj2.cloud.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.cloud.Cluster;
import ar.edu.unahur.obj2.cloud.misExceptiones.ValoresInvalidosException;

public class LiberarOperacionTest {
    @Test
    void testExecute() {
        Cluster cluster = new Cluster("C1", 100);
        LiberarOperacion liberarOperacion = new LiberarOperacion(cluster, 50);

        liberarOperacion.execute();

        assertEquals(50, cluster.getvCPUs());
    }

    @Test
    void testUndo() {
        Cluster cluster = new Cluster("C1", 100);
        LiberarOperacion liberarOperacion = new LiberarOperacion(cluster, 50);

        liberarOperacion.execute();

        assertEquals(50, cluster.getvCPUs());

        liberarOperacion.undo();
        assertEquals(100, cluster.getvCPUs());
    }

    @Test
    void testValoresInvalidos(){
        Cluster cluster = new Cluster("C1", 100);

        assertThrows(ValoresInvalidosException.class, () -> new LiberarOperacion(cluster, 0));
        
        assertThrows(ValoresInvalidosException.class, () -> new LiberarOperacion(cluster, -10));

    }
}
