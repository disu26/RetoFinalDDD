package co.com.rappi.delivery.orden.events;

import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenEntregada extends DomainEvent {
    public OrdenEntregada(){
        super("co.com.rappi.delivery.orden.events.OrdenEntregada");
    }
}
