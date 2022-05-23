package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarCalificacion extends Command {
    private final RestauranteId restauranteId;
    private final Calificacion calificacion;

    public ActualizarCalificacion(RestauranteId restauranteId, Calificacion calificacion){
        this.restauranteId = restauranteId;
        this.calificacion = calificacion;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Calificacion getCalificacion() {
        return calificacion;
    }
}
