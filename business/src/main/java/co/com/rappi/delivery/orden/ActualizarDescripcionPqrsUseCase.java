package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.ActualizarDescripcionPqrs;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarDescripcionPqrsUseCase extends UseCase<RequestCommand<ActualizarDescripcionPqrs>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarDescripcionPqrs> actualizarDescripcionPqrsRequestCommand) {
        var command = actualizarDescripcionPqrsRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.actualizarDescripcionPqrs(command.getDescripcion());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
