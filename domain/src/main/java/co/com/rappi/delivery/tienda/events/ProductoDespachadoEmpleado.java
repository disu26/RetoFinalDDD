package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.tienda.values.EmpleadoId;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class ProductoDespachadoEmpleado extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final ProductoId productoId;

    public ProductoDespachadoEmpleado(EmpleadoId empleadoId, ProductoId productoId) {
        super("co.com.rappi.delivery.tienda.events.ProductoDespachadoEmpleado");
        this.empleadoId = empleadoId;
        this.productoId = productoId;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public ProductoId getProductoId() {
        return productoId;
    }
}
