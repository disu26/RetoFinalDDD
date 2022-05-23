package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.ActualizarTelefonoUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarTelefonoUsuarioUseCase extends UseCase<RequestCommand<ActualizarTelefonoUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarTelefonoUsuario> actualizarTelefonoUsuarioRequestCommand) {
        var command = actualizarTelefonoUsuarioRequestCommand.getCommand();

        var cuenta = Cuenta.from(
                command.getCuentaId(), repository().getEventsBy(command.getCuentaId().value())
        );
        cuenta.actualizarTelefonoUsuario(command.getTelefono());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
