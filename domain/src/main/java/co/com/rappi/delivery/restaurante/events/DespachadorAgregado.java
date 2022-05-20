package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.DespachadorId;
import co.com.sofka.domain.generic.DomainEvent;

public final class DespachadorAgregado extends DomainEvent {
    private final DespachadorId despachadorId;
    private final Nombre nombre;

    public DespachadorAgregado(DespachadorId despachadorId, Nombre nombre) {
        super("co.com.rappi.delivery.restaurante.events.DespachadorAgregado");
        this.despachadorId = despachadorId;
        this.nombre = nombre;
    }

    public DespachadorId getDespachadorId() {
        return despachadorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
