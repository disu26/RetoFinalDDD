package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.sofka.domain.generic.DomainEvent;

public final class MedioPagoRappiPrimeActualizado extends DomainEvent {
    private final MedioPago medioPago;

    public MedioPagoRappiPrimeActualizado(MedioPago medioPago) {
        super("co.com.rappi.delivery.cuenta.events.MedioPagoRappiPrimeActualizado");
        this.medioPago = medioPago;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
}
