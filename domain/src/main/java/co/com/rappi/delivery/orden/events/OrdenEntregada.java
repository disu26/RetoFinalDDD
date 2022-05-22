package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenEntregada extends DomainEvent {
    private final OrdenId ordenId;
    private final Calificacion calificacion;

    public OrdenEntregada(OrdenId ordenId, Calificacion calificacion){
        super("co.com.rappi.delivery.orden.events.OrdenEntregada");
        this.ordenId = ordenId;
        this.calificacion = calificacion;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
