package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Respuesta;
import co.com.sofka.domain.generic.Command;

public final class AgregarRespuestaPqrs extends Command {
    private final OrdenId ordenId;
    private final Respuesta respuesta;

    public AgregarRespuestaPqrs(OrdenId ordenId, Respuesta respuesta){
        this.ordenId = ordenId;
        this.respuesta = respuesta;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }
}
