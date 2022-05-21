package co.com.rappi.delivery.orden.events;

import co.com.sofka.domain.generic.DomainEvent;

public final class LlevandoOrden extends DomainEvent {
    public LlevandoOrden(){
        super("co.com.rappi.delivery.orden.events.LlevandoOrden");
    }
}
