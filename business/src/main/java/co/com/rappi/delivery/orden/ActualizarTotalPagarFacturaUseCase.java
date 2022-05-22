package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.ActualizarTotalPagarFactura;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarTotalPagarFacturaUseCase extends UseCase<RequestCommand<ActualizarTotalPagarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTotalPagarFactura> actualizarTotalPagarFacturaRequestCommand) {
        var command = actualizarTotalPagarFacturaRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.actualizarTotalPagarFactura(command.getTotalPagar());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
