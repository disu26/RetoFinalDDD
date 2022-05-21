package co.com.rappi.delivery.restaurante.values;

import co.com.sofka.domain.generic.Identity;

public final class RestauranteId extends Identity {
    public RestauranteId(String id){
        super(id);
    }

    public static RestauranteId of(String id){
        return new RestauranteId(id);
    }
}
