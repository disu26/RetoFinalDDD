package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public final class PrecioServicioActualizado extends DomainEvent {
    private final ServicioId servicioId;
    private final Precio precio;

    public PrecioServicioActualizado(ServicioId servicioId, Precio precio) {
        super("co.com.rappi.delivery.tienda.events.PrecioProductoActualizado");
        this.servicioId = servicioId;
        this.precio = precio;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
