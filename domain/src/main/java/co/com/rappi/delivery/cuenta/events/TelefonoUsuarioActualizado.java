package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.generic.values.Telefono;
import co.com.sofka.domain.generic.DomainEvent;

public final class TelefonoUsuarioActualizado extends DomainEvent {
    private final Telefono telefono;

    public TelefonoUsuarioActualizado(Telefono telefono) {
        super("co.com.rappi.delivery.cuenta.events.TelefonoUsuarioActualizado");
        this.telefono = telefono;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
