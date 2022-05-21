package co.com.rappi.delivery.orden.events;

import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenPreparada extends DomainEvent {
    public OrdenPreparada(){
        super("co.com.rappi.delivery.orden.events.OrdenPreparada");
    }
}
