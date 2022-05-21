package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.Identity;

public final class FacturaId extends Identity {
    public FacturaId(String id){
        super(id);
    }

    public FacturaId(){

    }
    public static FacturaId of(String id){
        return new FacturaId(id);
    }
}
