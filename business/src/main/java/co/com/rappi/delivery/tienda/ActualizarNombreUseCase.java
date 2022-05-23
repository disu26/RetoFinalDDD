package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.ActualizarNombre;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarNombreUseCase extends UseCase<RequestCommand<ActualizarNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombre> actualizarNombreRequestCommand) {
        var command = actualizarNombreRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.actualizarNombre(command.getNombre());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
