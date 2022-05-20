package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.CocineroId;
import co.com.sofka.domain.generic.DomainEvent;

public final class NombreCocineroActualizado extends DomainEvent {
    private final CocineroId cocineroId;
    private final Nombre nombre;

    public NombreCocineroActualizado(CocineroId cocineroId, Nombre nombre) {
        super("co.com.rappi.delivery.restaurante.events.NombreCocineroActualizado");
        this.cocineroId = cocineroId;
        this.nombre = nombre;
    }

    public CocineroId getCocineroId() {
        return cocineroId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
