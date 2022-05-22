package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.events.OrdenEntregada;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public final class AgregarCalificacionRappiTenderoUseCase extends UseCase<TriggeredEvent<OrdenEntregada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<OrdenEntregada> ordenEntregadaTriggeredEvent) {
        var event = ordenEntregadaTriggeredEvent.getDomainEvent();

        var orden = Orden.from(
                event.getOrdenId(), repository().getEventsBy(event.getOrdenId().value())
        );
        orden.agregarCalificacionRappiTendero(event.getCalificacion());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
