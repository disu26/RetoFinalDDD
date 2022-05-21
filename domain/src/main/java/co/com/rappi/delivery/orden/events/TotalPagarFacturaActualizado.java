package co.com.rappi.delivery.orden.events;

import co.com.rappi.delivery.orden.values.TotalPagar;
import co.com.sofka.domain.generic.DomainEvent;

public final class TotalPagarFacturaActualizado extends DomainEvent {
    private final TotalPagar totalPagar;

    public TotalPagarFacturaActualizado(TotalPagar totalPagar) {
        super("co.com.rappi.delivery.orden.events.TotalPagarFacturaActualizado");
        this.totalPagar = totalPagar;
    }

    public TotalPagar getTotalPagar() {
        return totalPagar;
    }
}
