package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.AgregarCategoria;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarCategoriaUseCase extends UseCase<RequestCommand<AgregarCategoria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCategoria> agregarCategoriaRequestCommand) {
        var command = agregarCategoriaRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.agregarCategoria(command.getCategoria());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
