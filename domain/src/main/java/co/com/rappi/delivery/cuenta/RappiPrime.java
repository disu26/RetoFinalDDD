package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.values.Plan;
import co.com.rappi.delivery.cuenta.values.RappiPrimeId;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.sofka.domain.generic.Entity;

public class RappiPrime extends Entity<RappiPrimeId> {
    protected Plan plan;
    protected MedioPago medioPago;

    public RappiPrime(RappiPrimeId rappiPrimeId, Plan plan, MedioPago medioPago) {
        super(rappiPrimeId);
        this.plan = plan;
        this.medioPago = medioPago;
    }

    public void actualizarPlanBasico(){
        this.plan = new Plan(Plan.Planes.BASIC);
    }

    public void actualizarPlanPlus(){
        this.plan = new Plan(Plan.Planes.PLUS);
    }

    public void actualizarMedioPago(String medioPago){
        this.medioPago = new MedioPago(medioPago);
    }
}
