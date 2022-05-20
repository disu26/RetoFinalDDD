package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.tienda.values.EmpleadoId;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.sofka.domain.generic.DomainEvent;

public final class ServicioPrestadoEmpleado extends DomainEvent {
    private final EmpleadoId empleadoId;
    private final ServicioId servicioId;

    public ServicioPrestadoEmpleado(EmpleadoId empleadoId, ServicioId servicioId) {
        super("co.com.rappi.delivery.tienda.events.ServicioPrestadoEmpleado");
        this.empleadoId = empleadoId;
        this.servicioId = servicioId;
    }

    public EmpleadoId getEmpleadoId() {
        return empleadoId;
    }

    public ServicioId getServicioId() {
        return servicioId;
    }
}
