package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.sofka.domain.generic.Command;

public final class ActualizarMedioPagoRappiPrime extends Command {
    private final CuentaId cuentaId;
    private final MedioPago medioPago;

    public ActualizarMedioPagoRappiPrime(CuentaId cuentaId, MedioPago medioPago){
        this.cuentaId = cuentaId;
        this.medioPago = medioPago;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
}
