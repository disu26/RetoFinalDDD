package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarNombreCocinero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarNombreCocineroUseCase extends UseCase<RequestCommand<ActualizarNombreCocinero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreCocinero> actualizarNombreCocineroRequestCommand) {
        var command = actualizarNombreCocineroRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualizarNombreCocinero(command.getCocineroId(), command.getNombre());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
