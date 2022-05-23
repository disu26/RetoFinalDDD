package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarNombreMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarNombreMenuUseCase extends UseCase<RequestCommand<ActualizarNombreMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreMenu> actualizarNombreMenuRequestCommand) {
        var command = actualizarNombreMenuRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualizarNombreMenu(command.getMenuId(), command.getNombre());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
