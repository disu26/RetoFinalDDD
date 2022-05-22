package co.com.rappi.delivery;

import co.com.rappi.delivery.tienda.Tienda;
import co.com.rappi.delivery.tienda.commands.CrearTienda;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class CrearTiendaUseCase extends UseCase<RequestCommand<CrearTienda>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearTienda> crearTiendaRequestCommand) {
        var command = crearTiendaRequestCommand.getCommand();

        var tienda = new Tienda(command.getTiendaId(), command.getNombre(), command.getCostoEnvio());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
