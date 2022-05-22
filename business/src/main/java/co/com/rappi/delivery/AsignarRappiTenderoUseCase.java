package co.com.rappi.delivery;

import co.com.rappi.delivery.orden.Orden;
import co.com.rappi.delivery.orden.commands.AsignarRappiTendero;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AsignarRappiTenderoUseCase extends UseCase<RequestCommand<AsignarRappiTendero>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AsignarRappiTendero> agregarRappiTenderoRequestCommand) {
        var command = agregarRappiTenderoRequestCommand.getCommand();

        var orden = Orden.from(
                command.getOrdenId(), repository().getEventsBy(command.getOrdenId().value())
        );
        orden.asignarRappiTendero(command.getNombre(), command.getTelefono(), command.getPropina());

        emit().onResponse(new ResponseEvents(orden.getUncommittedChanges()));
    }
}
