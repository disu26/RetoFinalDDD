package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.ActualizarPropinaFactura;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarPropinaFacturaUseCase extends UseCase<RequestCommand<ActualizarPropinaFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPropinaFactura> actualizarPropinaFacturaRequestCommand) {
        var command = actualizarPropinaFacturaRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.actualizarPropinaFactura(command.getPropina());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
