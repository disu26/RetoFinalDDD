package co.com.rappi.delivery;

import co.com.rappi.delivery.restaurante.Restaurante;
import co.com.rappi.delivery.restaurante.commands.CrearRestaurante;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class CrearRestauranteUseCase extends UseCase<RequestCommand<CrearRestaurante>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRestaurante> crearRestauranteRequestCommand) {
        var command = crearRestauranteRequestCommand.getCommand();

        var restaurante = new Restaurante(command.getRestauranteId(), command.getNombre(),
                command.getCostoEnvio());

        emit().onResponse(new ResponseEvents(restaurante.getUncommittedChanges()));
    }
}
