package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.Identity;

public final class OrdenId extends Identity {
    public OrdenId(String id){
        super(id);
    }

    public static OrdenId of(String id){
        return new OrdenId(id);
    }
}
