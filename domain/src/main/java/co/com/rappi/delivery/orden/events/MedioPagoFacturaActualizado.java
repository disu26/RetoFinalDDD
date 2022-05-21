package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.orden.values.FacturaId;
import co.com.sofka.domain.generic.DomainEvent;

public final class MedioPagoFacturaActualizado extends DomainEvent {
    private final MedioPago medioPago;

    public MedioPagoFacturaActualizado(MedioPago medioPago) {
        super("co.com.rappi.delivery.orden.events.MedioPagoFacturaActualizado");
        this.medioPago = medioPago;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
}
