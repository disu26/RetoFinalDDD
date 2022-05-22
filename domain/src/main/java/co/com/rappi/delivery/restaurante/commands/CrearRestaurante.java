package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class CrearRestaurante extends Command {
    private final RestauranteId restauranteId;
    private final Nombre nombre;
    private final CostoEnvio costoEnvio;

    public CrearRestaurante(RestauranteId restauranteId, Nombre nombre, CostoEnvio costoEnvio){
        this.restauranteId = restauranteId;
        this.nombre = nombre;
        this.costoEnvio = costoEnvio;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public CostoEnvio getCostoEnvio() {
        return costoEnvio;
    }
}
