package co.com.rappi.delivery;

import co.com.rappi.delivery.orden.Orden;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.rappi.delivery.orden.commands.CrearOrdenRestaurante;

public final class CrearOrdenRestauranteUseCase extends UseCase<RequestCommand<CrearOrdenRestaurante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearOrdenRestaurante> crearOrdenRequestCommand) {
        var command = crearOrdenRequestCommand.getCommand();

        var orden = new Orden(command.getOrdenId(), command.getRestauranteId(), command.getCuentaId());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
