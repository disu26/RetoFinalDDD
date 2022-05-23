package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.AgregarUbicacion;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarUbicacionUseCase extends UseCase<RequestCommand<AgregarUbicacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUbicacion> agregarUbicacionRequestCommand) {
        var command = agregarUbicacionRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.agregarUbicacion(command.getUbicacion());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
