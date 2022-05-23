package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarCostoEnvio extends Command {
    private final TiendaId tiendaId;
    private final CostoEnvio costoEnvio;

    public ActualizarCostoEnvio(TiendaId tiendaId, CostoEnvio costoEnvio){
        this.tiendaId = tiendaId;
        this.costoEnvio = costoEnvio;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public CostoEnvio getCostoEnvio() {
        return costoEnvio;
    }
}
