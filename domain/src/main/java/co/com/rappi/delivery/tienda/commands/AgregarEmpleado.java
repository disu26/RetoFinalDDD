package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class AgregarEmpleado extends Command {
    private final TiendaId tiendaId;
    private final Nombre nombre;

    public AgregarEmpleado(TiendaId tiendaId, Nombre nombre){
        this.tiendaId = tiendaId;
        this.nombre = nombre;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
