package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenRestauranteCreada extends DomainEvent {
    private final RestauranteId restauranteId;
    private final CuentaId cuentaId;

    public OrdenRestauranteCreada(RestauranteId restauranteId, CuentaId cuentaId) {
        super("co.com.rappi.delivery.orden.events.OrdenRestauranteCreada");
        this.restauranteId = restauranteId;
        this.cuentaId = cuentaId;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
