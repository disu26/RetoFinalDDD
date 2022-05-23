package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.DespachadorId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarNombreDespachador extends Command {
    private final RestauranteId restauranteId;
    private final DespachadorId despachadorId;
    private final Nombre nombre;

    public ActualizarNombreDespachador(RestauranteId restauranteId, DespachadorId despachadorId, Nombre nombre){
        this.restauranteId = restauranteId;
        this.despachadorId = despachadorId;
        this.nombre = nombre;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public DespachadorId getDespachadorId() {
        return despachadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
