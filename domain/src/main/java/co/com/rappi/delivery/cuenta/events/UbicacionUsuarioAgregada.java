package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public final class UbicacionUsuarioAgregada extends DomainEvent {
    private final Ubicacion ubicacion;

    public UbicacionUsuarioAgregada(Ubicacion ubicacion) {
        super("co.com.rappi.delivery.cuenta.events.NombreUsuarioActualizado");
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
