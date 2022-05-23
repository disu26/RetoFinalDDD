package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarCalificacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarCalificacionUseCase extends UseCase<RequestCommand<ActualizarCalificacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCalificacion> actualizarCalificacionRequestCommand) {
        var command = actualizarCalificacionRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualizarCalificacion(command.getCalificacion());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
