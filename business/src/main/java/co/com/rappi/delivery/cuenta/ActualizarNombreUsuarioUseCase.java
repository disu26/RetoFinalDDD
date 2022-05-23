package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.ActualizarNombreUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarNombreUsuarioUseCase extends UseCase<RequestCommand<ActualizarNombreUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarNombreUsuario> actualizarNombreUsuarioRequestCommand) {
        var command = actualizarNombreUsuarioRequestCommand.getCommand();

        var cuenta = Cuenta.from(
                command.getCuentaId(), repository().getEventsBy(command.getCuentaId().value())
        );
        cuenta.actualizarNombreUsuario(command.getNombre());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
