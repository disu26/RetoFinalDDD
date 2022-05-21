package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class CrearOrdenTienda extends Command {
    private final OrdenId ordenId;
    private final TiendaId tiendaId;
    private final CuentaId cuentaId;

    public CrearOrdenTienda(OrdenId ordenId, TiendaId tiendaId, CuentaId cuentaId) {
        this.ordenId = ordenId;
        this.tiendaId = tiendaId;
        this.cuentaId = cuentaId;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }
}
