package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public final class NombreServicioActualizado extends DomainEvent {
    private final ServicioId servicioId;
    private final Nombre nombre;

    public NombreServicioActualizado(ServicioId servicioId, Nombre nombre) {
        super("co.com.rappi.delivery.tienda.events.NombreServicioActualizado");
        this.servicioId = servicioId;
        this.nombre = nombre;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
