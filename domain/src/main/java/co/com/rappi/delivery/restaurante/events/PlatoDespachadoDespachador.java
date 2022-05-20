package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.restaurante.values.DespachadorId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.sofka.domain.generic.DomainEvent;

public final class PlatoDespachadoDespachador extends DomainEvent {
    private final DespachadorId despachadorId;
    private final Plato plato;

    public PlatoDespachadoDespachador(DespachadorId despachadorId, Plato plato) {
        super("co.com.rappi.delivery.restaurante.events.PlatoDespachadoDespachador");
        this.despachadorId = despachadorId;
        this.plato = plato;
    }

    public DespachadorId getDespachadorId() {
        return despachadorId;
    }

    public Plato getPlato() {
        return plato;
    }
}
