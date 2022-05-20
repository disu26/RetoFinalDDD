package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.sofka.domain.generic.DomainEvent;

public final class UbicacionAgregada extends DomainEvent {
    private final Ubicacion ubicacion;

    public UbicacionAgregada(Ubicacion ubicacion) {
        super("co.com.rappi.delivery.restaurante.events.UbicacionAgregada");
        this.ubicacion = ubicacion;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
