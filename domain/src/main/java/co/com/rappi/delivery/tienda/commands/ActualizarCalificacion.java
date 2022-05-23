package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarCalificacion extends Command {
    private final TiendaId tiendaId;
    private final Calificacion calificacion;

    public ActualizarCalificacion(TiendaId tiendaId, Calificacion calificacion){
        this.tiendaId = tiendaId;
        this.calificacion = calificacion;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
