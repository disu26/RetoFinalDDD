package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.AgregarCategoria;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarCategoriaUseCase extends UseCase<RequestCommand<AgregarCategoria>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarCategoria> agregarCategoriaRequestCommand) {
        var command = agregarCategoriaRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.agregarCategoria(command.getCategoria());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
