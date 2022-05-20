package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.cuenta.values.RappiPayId;
import co.com.rappi.delivery.cuenta.values.Saldo;
import co.com.sofka.domain.generic.DomainEvent;

public final class RappiPayAgregado extends DomainEvent {
    private final RappiPayId rappiPayId;
    private final Saldo saldo;

    public RappiPayAgregado(RappiPayId rappiPayId, Saldo saldo) {
        super("co.com.rappi.delivery.cuenta.events.RappiPayAgregado");
        this.rappiPayId = rappiPayId;
        this.saldo = saldo;
    }

    public RappiPayId getRappiPayId() {
        return rappiPayId;
    }

    public Saldo getSaldo() {
        return saldo;
    }
}
