package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.cuenta.values.Plan;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.sofka.domain.generic.Command;

public final class AgregarRappiPrime extends Command {
    private final CuentaId cuentaId;
    private final Plan plan;
    private final MedioPago medioPago;

    public AgregarRappiPrime(CuentaId cuentaId, Plan plan, MedioPago medioPago){
        this.cuentaId = cuentaId;
        this.plan = plan;
        this.medioPago = medioPago;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Plan getPlan() {
        return plan;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
}
