package co.com.rappi.delivery.orden.events;

import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenRecibida extends DomainEvent {
    public OrdenRecibida(){
        super("co.com.rappi.delivery.orden.events.OrdenRecibida");
    }
}
