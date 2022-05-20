package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class PrecioProductoActualizado extends DomainEvent {
    private final ProductoId productoId;
    private final Precio precio;

    public PrecioProductoActualizado(ProductoId productoId, Precio precio) {
        super("co.com.rappi.delivery.tienda.events.PrecioProductoActualizado");
        this.productoId = productoId;
        this.precio = precio;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
