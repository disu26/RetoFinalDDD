package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class AgregarDespachador extends Command {
    private final RestauranteId restauranteId;
    private final Nombre nombre;

    public AgregarDespachador(RestauranteId restauranteId, Nombre nombre){
        this.restauranteId = restauranteId;
        this.nombre = nombre;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
