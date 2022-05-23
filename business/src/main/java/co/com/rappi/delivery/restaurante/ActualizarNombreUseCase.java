package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarNombre;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarNombreUseCase extends UseCase<RequestCommand<ActualizarNombre>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombre> actualizarNombreRequestCommand) {
        var command = actualizarNombreRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualizarNombre(command.getNombre());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
