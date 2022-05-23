package co.com.rappi.delivery.tienda;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarCostoEnvioUseCase extends UseCase<RequestCommand<co.com.rappi.delivery.tienda.commands.ActualizarCostoEnvio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<co.com.rappi.delivery.tienda.commands.ActualizarCostoEnvio> actualizarCostoEnvioRequestCommand) {
        var command = actualizarCostoEnvioRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.actualiazarCostoEnvio(command.getCostoEnvio());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
