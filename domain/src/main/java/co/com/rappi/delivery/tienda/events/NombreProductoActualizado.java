package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class NombreProductoActualizado extends DomainEvent {
    private final ProductoId productoId;
    private final Nombre nombre;

    public NombreProductoActualizado(ProductoId productoId, Nombre nombre) {
        super("co.com.rappi.delivery.tienda.events.NombreProductoActualizado");
        this.productoId = productoId;
        this.nombre = nombre;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
