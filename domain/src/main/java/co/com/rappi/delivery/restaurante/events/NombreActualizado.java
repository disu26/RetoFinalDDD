package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public final class NombreActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreActualizado(Nombre nombre) {
        super("co.com.rappi.delivery.restaurante.events.NombreActualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
