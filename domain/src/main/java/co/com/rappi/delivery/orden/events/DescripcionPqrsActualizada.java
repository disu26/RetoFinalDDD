package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.orden.values.Descripcion;
import co.com.rappi.delivery.orden.values.PqrsId;
import co.com.sofka.domain.generic.DomainEvent;

public final class DescripcionPqrsActualizada extends DomainEvent {
    private final Descripcion descripcion;

    public DescripcionPqrsActualizada(Descripcion descripcion) {
        super("co.com.rappi.delivery.orden.events.DescripcionPqrsActualizada");
        this.descripcion = descripcion;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
