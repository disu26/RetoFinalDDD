package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.Command;

public final class AsignarRappiTendero extends Command {
    private final OrdenId ordenId;
    private final Nombre nombre;
    private final Telefono telefono;
    private final Propina propina;

    public AsignarRappiTendero(OrdenId ordenId, Nombre nombre, Telefono telefono, Propina propina){
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
