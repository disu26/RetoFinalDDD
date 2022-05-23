package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarPrecioMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarPrecioMenuUseCase extends UseCase<RequestCommand<ActualizarPrecioMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarPrecioMenu> actualizarPrecioMenuRequestCommand) {
        var command = actualizarPrecioMenuRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualizarPrecioMenu(command.getMenuId(), command.getPrecio());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
