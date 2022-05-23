package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarCostoEnvio extends Command {
    private final RestauranteId restauranteId;
    private final CostoEnvio costoEnvio;

    public ActualizarCostoEnvio(RestauranteId restauranteId, CostoEnvio costoEnvio){
        this.restauranteId = restauranteId;
        this.costoEnvio = costoEnvio;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public CostoEnvio getCostoEnvio() {
        return costoEnvio;
    }
}
