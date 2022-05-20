package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.values.EmpleadoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class EmpleadoAgregado extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final Nombre nombre;

    public EmpleadoAgregado(EmpleadoId empleadoId, Nombre nombre) {
        super("co.com.rappi.delivery.tienda.events.ProductoAgregado");
        this.empleadoId = empleadoId;
        this.nombre = nombre;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
