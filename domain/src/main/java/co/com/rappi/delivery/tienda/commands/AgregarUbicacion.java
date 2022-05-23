package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class AgregarUbicacion extends Command {
    private final TiendaId tiendaId;
    private final Ubicacion ubicacion;

    public AgregarUbicacion(TiendaId tiendaId, Ubicacion ubicacion){
        this.tiendaId = tiendaId;
        this.ubicacion = ubicacion;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
