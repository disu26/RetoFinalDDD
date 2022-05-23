package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.AgregarPlatoMenu;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarPlatoMenuUseCase extends UseCase<RequestCommand<AgregarPlatoMenu>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPlatoMenu> agregarPlatoMenuRequestCommand) {
        var command = agregarPlatoMenuRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.agregarPlatoMenu(command.getMenuId(), command.getPlato());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
