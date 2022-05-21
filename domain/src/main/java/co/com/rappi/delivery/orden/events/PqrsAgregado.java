package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.orden.values.Descripcion;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.PqrsId;
import co.com.sofka.domain.generic.DomainEvent;

public final class PqrsAgregado extends DomainEvent {
    private final PqrsId pqrsId;
    private final Descripcion descripcion;
    private final Fecha fecha;

    public PqrsAgregado(PqrsId pqrsId, Descripcion descripcion, Fecha fecha) {
        super("co.com.rappi.delivery.orden.events.PqrsAgregado");
        this.pqrsId = pqrsId;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public PqrsId getPqrsId() {
        return pqrsId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
