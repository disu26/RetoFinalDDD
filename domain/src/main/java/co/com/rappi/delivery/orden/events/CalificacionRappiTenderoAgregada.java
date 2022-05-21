package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.orden.values.RappiTenderoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class CalificacionRappiTenderoAgregada extends DomainEvent {
    private final Calificacion calificacion;

    public CalificacionRappiTenderoAgregada(Calificacion calificacion) {
        super("co.com.rappi.delivery.orden.events.CalificacionRappiTenderoAgregada");
        this.calificacion = calificacion;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
