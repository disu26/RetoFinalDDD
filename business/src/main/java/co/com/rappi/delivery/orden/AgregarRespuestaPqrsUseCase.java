package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.commands.AgregarRespuestaPqrs;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarRespuestaPqrsUseCase extends UseCase<RequestCommand<AgregarRespuestaPqrs>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRespuestaPqrs> agregarRespuestaPqrsRequestCommand) {
        var command = agregarRespuestaPqrsRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.agregarRespuestaPqrs(command.getRespuesta());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
