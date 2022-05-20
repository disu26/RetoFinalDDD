package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public final class NombreUsuarioActualizado extends DomainEvent {
    private final Nombre nombre;

    public NombreUsuarioActualizado(Nombre nombre) {
        super("co.com.rappi.delivery.cuenta.events.NombreUsuarioActualizado");
        this.nombre = nombre;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
