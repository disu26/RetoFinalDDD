package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.GenerarFactura;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class GenerarFacturaUseCase extends UseCase<RequestCommand<GenerarFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<GenerarFactura> generarFacturaRequestCommand) {
        var command = generarFacturaRequestCommand.getCommand();
        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.generarFactura(command.getFecha(), command.getMedioPago(), command.getPropina());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
