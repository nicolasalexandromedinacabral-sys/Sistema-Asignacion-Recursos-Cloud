package ar.edu.unahur.obj2.cloud.composite;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.cloud.command.Operacion;
import ar.edu.unahur.obj2.cloud.misExceptiones.LimiteDeOverprovisioningException;

public class PlanDeDespliegues implements Operacion {
    private List<Operacion> operaciones = new ArrayList<>();
    private List<Operacion> ejecutadas = new ArrayList<>();

    @Override
    public void execute() {
        try {
            for (Operacion op : operaciones) {
                op.execute();
                ejecutadas.add(op);
            }
        } catch (LimiteDeOverprovisioningException e) {
            for (Integer i = ejecutadas.size() - 1; i >= 0; i--) {
                ejecutadas.get(i).undo();
            }
            throw e;
        }
    }

    @Override
    public void undo() {
        for (Integer i = ejecutadas.size() - 1; i >= 0; i--) {
            ejecutadas.get(i).undo();
        }
    }

    public void addOperacion(Operacion op) {
        operaciones.add(op);
    }

    public void vaciar() {
        operaciones.clear();
        ejecutadas.clear();
    }

}
