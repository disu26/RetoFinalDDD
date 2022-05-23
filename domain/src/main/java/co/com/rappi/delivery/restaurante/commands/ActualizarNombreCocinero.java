package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.CocineroId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarNombreCocinero extends Command {
    private final RestauranteId restauranteId;
    private final CocineroId cocineroId;
    private final Nombre nombre;

    public ActualizarNombreCocinero(RestauranteId restauranteId, CocineroId cocineroId, Nombre nombre){
        this.restauranteId = restauranteId;
        this.cocineroId = cocineroId;
        this.nombre = nombre;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public CocineroId getCocineroId() {
        return cocineroId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
