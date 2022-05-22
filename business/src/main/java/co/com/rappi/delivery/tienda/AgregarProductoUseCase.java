package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.AgregarProducto;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarProductoUseCase extends UseCase<RequestCommand<AgregarProducto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarProducto> agregarProductoRequestCommand) {
        var command = agregarProductoRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.agregarProducto(command.getCategoria(), command.getPrecio(), command.getNombre());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
