package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class AgregarUbicacion extends Command {
    private final RestauranteId restauranteId;
    private final Ubicacion ubicacion;

    public AgregarUbicacion(RestauranteId restauranteId, Ubicacion ubicacion){
        this.restauranteId = restauranteId;
        this.ubicacion = ubicacion;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
