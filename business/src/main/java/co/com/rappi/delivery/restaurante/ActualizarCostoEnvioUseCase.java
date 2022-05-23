package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.restaurante.commands.ActualizarCostoEnvio;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarCostoEnvioUseCase extends UseCase<RequestCommand<ActualizarCostoEnvio>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarCostoEnvio> actualizarCostoEnvioRequestCommand) {
        var command = actualizarCostoEnvioRequestCommand.getCommand();

        var restaurante = Restaurante.from(
                command.getRestauranteId(), repository().getEventsBy(command.getRestauranteId().value())
        );
        restaurante.actualiazarCostoEnvio(command.getCostoEnvio());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
