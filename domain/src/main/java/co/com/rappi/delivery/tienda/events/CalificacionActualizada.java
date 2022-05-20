package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.sofka.domain.generic.DomainEvent;

public final class CalificacionActualizada extends DomainEvent {
    private final Calificacion calificacion;

    public CalificacionActualizada(Calificacion calificacion) {
        super("co.com.rappi.delivery.tienda.events.CalificacionActualizada");
        this.calificacion = calificacion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
