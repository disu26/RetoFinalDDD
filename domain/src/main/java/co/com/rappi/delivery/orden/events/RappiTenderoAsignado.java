package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.rappi.delivery.orden.values.RappiTenderoId;
import co.com.sofka.domain.generic.DomainEvent;

public final class RappiTenderoAsignado extends DomainEvent {
    private final RappiTenderoId rappiTenderoId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Propina propina;

    public RappiTenderoAsignado(RappiTenderoId rappiTenderoId, Nombre nombre, Telefono telefono, Propina propina) {
        super("co.com.rappi.delivery.orden.events.OrdenRecibida");
        this.rappiTenderoId = rappiTenderoId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.propina = propina;
    }

    public RappiTenderoId getRappiTenderoId() {
        return rappiTenderoId;
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
