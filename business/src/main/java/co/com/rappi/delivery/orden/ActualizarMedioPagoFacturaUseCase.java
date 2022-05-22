package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.ActualizarMedioPagoFactura;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarMedioPagoFacturaUseCase extends UseCase<RequestCommand<ActualizarMedioPagoFactura>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarMedioPagoFactura> actualizarMedioPagoFacturaRequestCommand) {
        var command = actualizarMedioPagoFacturaRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.actualizarMedioPagoFactura(command.getMedioPago());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
