package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.cuenta.values.RappiPrimeId;
import co.com.sofka.domain.generic.DomainEvent;

public final class RappiPrimeActualizadoAPlanBasico extends DomainEvent {
    public RappiPrimeActualizadoAPlanBasico() {
        super("co.com.rappi.delivery.cuenta.events.RappiPrimeActualizadoAPlanBasico");
    }
}
