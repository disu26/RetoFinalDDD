package co.com.rappi.delivery;

import co.com.rappi.delivery.restaurante.Restaurante;
import co.com.rappi.delivery.restaurante.commands.AgregarMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarMenuUseCase extends UseCase<RequestCommand<AgregarMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarMenu> agregarMenuRequestCommand) {
        var command = agregarMenuRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.agregarMenu(command.getNombre(), command.getPrecio());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
