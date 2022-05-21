package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class CrearOrdenRestaurante extends Command {
    private final OrdenId ordenId;
    private final RestauranteId restauranteId;
    private final CuentaId cuentaId;

    public CrearOrdenRestaurante(OrdenId ordenId, RestauranteId restauranteId, CuentaId cuentaId) {
        this.ordenId = ordenId;
        this.restauranteId = restauranteId;
        this.cuentaId = cuentaId;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
