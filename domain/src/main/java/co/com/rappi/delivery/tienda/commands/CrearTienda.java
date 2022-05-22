package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class CrearTienda extends Command {
    private final TiendaId tiendaId;
    private final Nombre nombre;
    private final CostoEnvio costoEnvio;

    public CrearTienda(TiendaId tiendaId, Nombre nombre, CostoEnvio costoEnvio){
        this.tiendaId = tiendaId;
        this.nombre = nombre;
        this.costoEnvio = costoEnvio;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public CostoEnvio getCostoEnvio() {
        return costoEnvio;
    }
}
