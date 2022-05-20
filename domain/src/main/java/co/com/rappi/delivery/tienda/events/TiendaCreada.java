package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public final class TiendaCreada extends DomainEvent {
    private final Nombre nombre;
    private final CostoEnvio costoEnvio;

    public TiendaCreada(Nombre nombre, CostoEnvio costoEnvio) {
        super("co.com.rappi.delivery.tienda.events.TiendaCreada");
        this.nombre = nombre;
        this.costoEnvio = costoEnvio;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public CostoEnvio getCostoEnvio() {
        return costoEnvio;
    }
}
