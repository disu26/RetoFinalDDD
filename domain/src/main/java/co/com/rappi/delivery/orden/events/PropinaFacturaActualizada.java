package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.DomainEvent;

public final class PropinaFacturaActualizada extends DomainEvent {
    private final Propina propina;

    public PropinaFacturaActualizada(Propina propina) {
        super("co.com.rappi.delivery.orden.events.PropinaFacturaActualizada");
        this.propina = propina;
    }

    public Propina getPropina() {
        return propina;
    }
}
