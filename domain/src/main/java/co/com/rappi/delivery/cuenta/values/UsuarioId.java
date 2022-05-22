package co.com.rappi.delivery.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public final class UsuarioId extends Identity {
    public UsuarioId(String id){
        super(id);
    }

    public static UsuarioId of(String id){
        return new UsuarioId(id);
    }
}
