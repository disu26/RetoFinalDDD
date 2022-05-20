package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.cuenta.values.Plan;
import co.com.rappi.delivery.cuenta.values.RappiPrimeId;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.sofka.domain.generic.DomainEvent;

public final class RappiPrimeAgregado extends DomainEvent {
    private final RappiPrimeId rappiPrimeId;
    private final Plan plan;
    private final MedioPago medioPago;

    public RappiPrimeAgregado(RappiPrimeId rappiPrimeId, Plan plan, MedioPago medioPago) {
        super("co.com.rappi.delivery.cuenta.events.RappiPrimeAgregado");
        this.rappiPrimeId = rappiPrimeId;
        this.plan = plan;
        this.medioPago = medioPago;
    }

    public RappiPrimeId getRappiPrimeId() {
        return rappiPrimeId;
    }

    public Plan getPlan() {
        return plan;
    }

    public MedioPago getMedioPago() {
        return medioPago;
    }
}
