package co.com.rappi.delivery.cuenta.values;

import co.com.sofka.domain.generic.Identity;

public final class RappiPrimeId extends Identity {
    public RappiPrimeId(String id){
        super(id);
    }

    public RappiPrimeId() {}

    public static RappiPrimeId of(String id){
        return new RappiPrimeId(id);
    }
}
