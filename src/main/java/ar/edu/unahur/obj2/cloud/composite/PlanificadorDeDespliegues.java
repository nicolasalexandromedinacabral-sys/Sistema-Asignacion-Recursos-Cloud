package ar.edu.unahur.obj2.cloud.composite;


import ar.edu.unahur.obj2.cloud.command.Operacion;

public class PlanificadorDeDespliegues  {
    private PlanDeDespliegues plan = new PlanDeDespliegues(); 

    public void ejecutarOperacion(Operacion op){
        op.execute();
    }

    public void registrarOperacion(Operacion op){
        plan.addOperacion(op);
    }

    public void ejecutarPlan(){
        plan.execute();
        plan.vaciar();
    }


}
