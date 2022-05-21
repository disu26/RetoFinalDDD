package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenTiendaCreada extends DomainEvent {
    private final TiendaId tiendaId;
    private final CuentaId cuentaId;

    public OrdenTiendaCreada(TiendaId tiendaId, CuentaId cuentaId) {
        super("co.com.rappi.delivery.orden.events.OrdenTiendaCreada");
        this.tiendaId = tiendaId;
        this.cuentaId = cuentaId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
