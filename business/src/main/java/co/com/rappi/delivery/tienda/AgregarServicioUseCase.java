package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.AgregarServicio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarServicioUseCase extends UseCase<RequestCommand<AgregarServicio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarServicio> agregarServicioRequestCommand) {
        var command = agregarServicioRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.agregarServicio(command.getNombre(), command.getPrecio());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
