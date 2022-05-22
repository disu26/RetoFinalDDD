package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.Identity;

public final class PqrsId extends Identity {
    public PqrsId(String id){
        super(id);
    }

    public PqrsId(){

    }
    public static PqrsId of(String id){
        return new PqrsId(id);
    }
}
