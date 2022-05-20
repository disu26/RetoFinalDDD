package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class ProductoAgregado extends DomainEvent {
    private final ProductoId productoId;
    private final Categoria categoria;
    private final Precio precio;
    private final Nombre nombre;

    public ProductoAgregado(ProductoId productoId, Categoria categoria, Precio precio, Nombre nombre) {
        super("co.com.rappi.delivery.tienda.events.ProductoAgregado");
        this.productoId = productoId;
        this.categoria = categoria;
        this.precio = precio;
        this.nombre = nombre;
    }

    public ProductoId getProductoId() {
        return productoId;
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
