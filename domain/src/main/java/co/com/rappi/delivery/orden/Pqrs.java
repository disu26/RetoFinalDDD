package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.values.Descripcion;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.PqrsId;
import co.com.rappi.delivery.orden.values.Respuesta;
import co.com.sofka.domain.generic.Entity;

public class Pqrs extends Entity<PqrsId> {
    protected Descripcion descripcion;
    protected Respuesta respuesta;
    protected Fecha fecha;

    public Pqrs(PqrsId pqrsId, Descripcion descripcion, Fecha fecha) {
        super(pqrsId);
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public void agregarRespuesta(Respuesta respuesta){
        this.respuesta = respuesta;
    }

    public void actualizarDescripcion(String value){
        this.descripcion = new Descripcion(value);
    }
}
