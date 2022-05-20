package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.restaurante.values.CocineroId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.sofka.domain.generic.DomainEvent;

public final class PlatoCocinadoCocinero extends DomainEvent {
    private final CocineroId cocineroId;
    private final Plato plato;

    public PlatoCocinadoCocinero(CocineroId cocineroId, Plato plato) {
        super("co.com.rappi.delivery.restaurante.events.PlatoCocinadoCocinero");
        this.cocineroId = cocineroId;
        this.plato = plato;
    }

    public CocineroId getCocineroId() {
        return cocineroId;
    }

    public Plato getPlato() {
        return plato;
    }
}
