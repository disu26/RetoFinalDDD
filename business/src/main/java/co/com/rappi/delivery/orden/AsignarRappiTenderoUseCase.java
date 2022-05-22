package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.events.OrdenPreparada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public final class AsignarRappiTenderoUseCase extends UseCase<TriggeredEvent<OrdenPreparada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<OrdenPreparada> ordenPreparadaTriggeredEvent) {
        var event = ordenPreparadaTriggeredEvent.getDomainEvent();

        var orden = Orden.from(
                event.getOrdenId(), repository().getEventsBy(event.getOrdenId().value())
        );
        orden.asignarRappiTendero(event.getNombre(), event.getTelefono(), event.getPropina());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
