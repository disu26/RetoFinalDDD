package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.Command;

public final class GenerarFactura extends Command {
    private final OrdenId ordenId;
    private final Fecha fecha;
    private final MedioPago medioPago;
    private final Propina propina;

    public GenerarFactura(OrdenId ordenId, Fecha fecha, MedioPago medioPago, Propina propina){
        this.ordenId = ordenId;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.propina = propina;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }

    public Propina getPropina() {
        return propina;
    }
}
