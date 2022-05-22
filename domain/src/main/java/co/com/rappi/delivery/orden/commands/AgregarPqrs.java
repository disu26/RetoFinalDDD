package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.orden.values.Descripcion;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.sofka.domain.generic.Command;

public final class AgregarPqrs extends Command {
    private final OrdenId ordenId;
    private final Descripcion descripcion;
    private final Fecha fecha;

    public AgregarPqrs(OrdenId ordenId, Descripcion descripcion, Fecha fecha){
        this.ordenId = ordenId;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }

    public Fecha getFecha() {
        return fecha;
    }
}
