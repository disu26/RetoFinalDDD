package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarNombreDespachador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarNombreDespachadorUseCase extends UseCase<RequestCommand<ActualizarNombreDespachador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreDespachador> actualizarNombreDespachadorRequestCommand) {
        var command = actualizarNombreDespachadorRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualizarNombreDespachador(command.getDespachadorId(), command.getNombre());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
