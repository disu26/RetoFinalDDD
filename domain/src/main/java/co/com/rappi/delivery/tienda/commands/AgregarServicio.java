package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class AgregarServicio extends Command {
    private final TiendaId tiendaId;
    private final Nombre nombre;
    private final Precio precio;

    public AgregarServicio(TiendaId tiendaId, Nombre nombre, Precio precio){
        this.tiendaId = tiendaId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
