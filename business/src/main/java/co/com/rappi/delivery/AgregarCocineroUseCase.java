package co.com.rappi.delivery;

import co.com.rappi.delivery.restaurante.Restaurante;
import co.com.rappi.delivery.restaurante.commands.AgregarCocinero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarCocineroUseCase extends UseCase<RequestCommand<AgregarCocinero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCocinero> agregarCocineroRequestCommand) {
        var command = agregarCocineroRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.agregarCocinero(command.getNombre());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
