package co.com.rappi.delivery;

import co.com.rappi.delivery.orden.Orden;
import co.com.rappi.delivery.orden.commands.AgregarPqrs;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarPqrsUseCase extends UseCase<RequestCommand<AgregarPqrs>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarPqrs> agregarPqrsUseCaseRequestCommand) {
        var command = agregarPqrsUseCaseRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.agregarPqrs(command.getDescripcion(), command.getFecha());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
