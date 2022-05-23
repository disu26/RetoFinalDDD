package co.com.rappi.delivery.restaurante.values;

import co.com.sofka.domain.generic.Identity;

public final class CocineroId extends Identity {
    public CocineroId(String id){
        super(id);
    }

    public CocineroId(){}

    public static CocineroId of(String id){
        return new CocineroId(id);
    }
}
