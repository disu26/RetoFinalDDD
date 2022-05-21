package co.com.rappi.delivery;

import co.com.rappi.delivery.orden.Orden;
import co.com.rappi.delivery.orden.commands.CrearOrdenTienda;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class CrearOrdenTiendaUseCase extends UseCase<RequestCommand<CrearOrdenTienda>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearOrdenTienda> crearOrdenTiendaRequestCommand) {
        var command = crearOrdenTiendaRequestCommand.getCommand();

        var orden = new Orden(command.getOrdenId(), command.getTiendaId(), command.getCuentaId());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
