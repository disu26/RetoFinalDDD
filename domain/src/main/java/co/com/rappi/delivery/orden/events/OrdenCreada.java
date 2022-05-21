package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.orden.Factura;
import co.com.rappi.delivery.orden.RappiTendero;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenCreada extends DomainEvent {
    private final RestauranteId restauranteId;
    private final CuentaId cuentaId;
    private final Factura factura;

    public OrdenCreada(RestauranteId restauranteId, CuentaId cuentaId, Factura factura) {
        super("co.com.rappi.delivery.orden.events.OrdenCreada");
        this.restauranteId = restauranteId;
        this.cuentaId = cuentaId;
        this.factura = factura;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Factura getFactura() {
        return factura;
    }
}
