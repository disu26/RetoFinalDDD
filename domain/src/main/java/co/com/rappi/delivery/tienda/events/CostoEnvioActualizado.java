package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.sofka.domain.generic.DomainEvent;

public final class CostoEnvioActualizado extends DomainEvent {
    private final CostoEnvio costoEnvio;

    public CostoEnvioActualizado(CostoEnvio costoEnvio) {
        super("co.com.rappi.delivery.tienda.events.CostoEnvioActualizado");
        this.costoEnvio = costoEnvio;
    }

    public CostoEnvio getCostoEnvio() {
        return costoEnvio;
    }
}
