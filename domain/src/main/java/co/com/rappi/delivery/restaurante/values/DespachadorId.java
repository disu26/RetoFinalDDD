package co.com.rappi.delivery.restaurante.values;

import co.com.sofka.domain.generic.Identity;

public final class DespachadorId extends Identity {
    public DespachadorId(String id){
        super(id);
    }

    public DespachadorId(){}

    public static DespachadorId of(String id){
        return new DespachadorId(id);
    }
}
