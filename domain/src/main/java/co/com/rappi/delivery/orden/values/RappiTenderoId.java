package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.Identity;

public final class RappiTenderoId extends Identity {
    public RappiTenderoId(String id){
        super(id);
    }

    public RappiTenderoId(){

    }

    public static RappiTenderoId of(String id){
        return new RappiTenderoId(id);
    }
}
