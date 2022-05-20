package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class CategoriaProductoActualizada extends DomainEvent {
    private final ProductoId productoId;
    private final Categoria categoria;

    public CategoriaProductoActualizada(ProductoId productoId, Categoria categoria) {
        super("co.com.rappi.delivery.tienda.events.CategoriaAgregada");
        this.productoId = productoId;
        this.categoria = categoria;
    }

    public ProductoId getProductoId() {
        return productoId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
