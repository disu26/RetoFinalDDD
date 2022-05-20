package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public final class RestauranteCreado extends DomainEvent {
    private final Nombre nombre;
    private final CostoEnvio costoEnvio;

    public RestauranteCreado(Nombre nombre, CostoEnvio costoEnvio) {
        super("co.com.rappi.delivery.restaurante.events.RestauranteCreado");
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
