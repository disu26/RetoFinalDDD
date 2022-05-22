package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class AgregarProducto extends Command {
    private final TiendaId tiendaId;
    private final Categoria categoria;
    private final Precio precio;
    private final Nombre nombre;

    public AgregarProducto(TiendaId tiendaId, Categoria categoria, Precio precio, Nombre nombre){
        this.tiendaId = tiendaId;
        this.categoria = categoria;
        this.precio = precio;
        this.nombre = nombre;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Precio getPrecio() {
        return precio;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
