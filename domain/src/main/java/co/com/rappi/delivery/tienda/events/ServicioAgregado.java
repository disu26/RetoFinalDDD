package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public final class ServicioAgregado extends DomainEvent {
    private final ServicioId servicioId;
    private final Nombre nombre;
    private final Precio precio;

    public ServicioAgregado(ServicioId servicioId, Nombre nombre, Precio precio) {
        super("co.com.rappi.delivery.tienda.events.ServicioAgregado");
        this.servicioId = servicioId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
