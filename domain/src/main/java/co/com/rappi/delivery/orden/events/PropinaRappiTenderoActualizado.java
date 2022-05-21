package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.DomainEvent;

public final class PropinaRappiTenderoActualizado extends DomainEvent {
    private final Propina propina;

    public PropinaRappiTenderoActualizado(Propina propina) {
        super("co.com.rappi.delivery.orden.events.PropinaRappiTenderoActualizado");
        this.propina = propina;
    }

    public Propina getPropina() {
        return propina;
    }
}
