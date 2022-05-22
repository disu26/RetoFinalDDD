package co.com.rappi.delivery.orden.commands;

import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.TotalPagar;
import co.com.sofka.domain.generic.Command;

public final class ActualizarTotalPagarFactura extends Command {
    private final OrdenId ordenId;
    private final TotalPagar totalPagar;

    public ActualizarTotalPagarFactura(OrdenId ordenId, TotalPagar totalPagar){
        this.ordenId = ordenId;
        this.totalPagar = totalPagar;
    }

    public OrdenId getOrdenId() {
        return ordenId;
    }

    public TotalPagar getTotalPagar() {
        return totalPagar;
    }
}
