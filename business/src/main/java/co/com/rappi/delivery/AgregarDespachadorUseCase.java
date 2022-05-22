package co.com.rappi.delivery;

import co.com.rappi.delivery.restaurante.Restaurante;
import co.com.rappi.delivery.restaurante.commands.AgregarDespachador;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarDespachadorUseCase extends UseCase<RequestCommand<AgregarDespachador>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarDespachador> agregarDespachadorRequestCommand) {
        var command = agregarDespachadorRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.agregarDespachador(command.getNombre());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
