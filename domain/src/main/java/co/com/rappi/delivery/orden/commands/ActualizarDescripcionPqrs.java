package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.orden.values.Descripcion;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarDescripcionPqrs extends Command {
    private final OrdenId ordenId;
    private final Descripcion descripcion;

    public ActualizarDescripcionPqrs(OrdenId ordenId, Descripcion descripcion){
        this.ordenId = ordenId;
        this.descripcion = descripcion;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
