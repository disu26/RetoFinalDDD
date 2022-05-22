package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.DomainEvent;

public final class OrdenPreparada extends DomainEvent {
    private final OrdenId ordenId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Propina propina;

    public OrdenPreparada(OrdenId ordenId, Nombre nombre, Telefono telefono, Propina propina){
        super("co.com.rappi.delivery.orden.events.OrdenPreparada");
        this.ordenId = ordenId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.propina = propina;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Propina getPropina() {
        return propina;
    }
}
