package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.orden.values.FacturaId;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.DomainEvent;

public final class FacturaGenerada extends DomainEvent {
    private final FacturaId facturaId;
    private final Fecha fecha;
    private final MedioPago medioPago;
    private final Propina propina;

    public FacturaGenerada(FacturaId facturaId, Fecha fecha, MedioPago medioPago, Propina propina) {
        super("co.com.rappi.delivery.orden.events.MedioPagoFacturaActualizado");
        this.facturaId = facturaId;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.propina = propina;
    }

    public FacturaId getFacturaId() {
        return facturaId;
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
