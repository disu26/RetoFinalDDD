package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.ActualizarCalificacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarCalificacionUseCase extends UseCase<RequestCommand<ActualizarCalificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCalificacion> actualizarCalificacionRequestCommand) {
        var command = actualizarCalificacionRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.actualizarCalificacion(command.getCalificacion());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
