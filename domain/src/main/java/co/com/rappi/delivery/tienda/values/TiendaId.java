package co.com.rappi.delivery.tienda.values;

import co.com.sofka.domain.generic.Identity;

public final class TiendaId extends Identity {
    public TiendaId(String id){
        super(id);
    }

    public static TiendaId of(String id){
        return new TiendaId(id);
    }
}
