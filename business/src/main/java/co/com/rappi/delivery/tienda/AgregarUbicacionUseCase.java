package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.AgregarUbicacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarUbicacionUseCase extends UseCase<RequestCommand<AgregarUbicacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUbicacion> agregarUbicacionRequestCommand) {
        var command = agregarUbicacionRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.agregarUbicacion(command.getUbicacion());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
