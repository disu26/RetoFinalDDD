package co.com.rappi.delivery.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public final class CuentaId extends Identity {
    public CuentaId(String id){
        super(id);
    }

    public static CuentaId of(String id){
        return new CuentaId(id);
    }
}
