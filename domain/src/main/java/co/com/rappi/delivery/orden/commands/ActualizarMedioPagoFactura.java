package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarMedioPagoFactura extends Command {
    private final OrdenId ordenId;
    private final MedioPago medioPago;

    public ActualizarMedioPagoFactura(OrdenId ordenId, MedioPago medioPago){
        this.ordenId = ordenId;
        this.medioPago = medioPago;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
}
