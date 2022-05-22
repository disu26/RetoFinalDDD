package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.ActualizarPropinaRappiTendero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarPropinaRappiTenderoUseCase extends UseCase<RequestCommand<ActualizarPropinaRappiTendero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPropinaRappiTendero> actualizarPropinaRappiTenderoRequestCommand) {
        var command = actualizarPropinaRappiTenderoRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.actualizarPropinaRappiTendero(command.getPropina());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
