package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.orden.values.PqrsId;
import co.com.rappi.delivery.orden.values.Respuesta;
import co.com.sofka.domain.generic.DomainEvent;

public final class RespuestaPqrsAgregado extends DomainEvent {
    private final Respuesta respuesta;

    public RespuestaPqrsAgregado(Respuesta respuesta) {
        super("co.com.rappi.delivery.orden.events.RespuestaPqrsAgregado");
        this.respuesta = respuesta;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }
}
