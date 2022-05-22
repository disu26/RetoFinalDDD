package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.sofka.domain.generic.Command;

public final class ActualizarPropinaRappiTendero extends Command {
    private final OrdenId ordenId;
    private final Propina propina;

    public ActualizarPropinaRappiTendero(OrdenId ordenId, Propina propina){
        this.ordenId = ordenId;
        this.propina = propina;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public Propina getPropina() {
        return propina;
    }
}
