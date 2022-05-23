package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.AgregarUbicacionUsuario;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarUbicacionUsuarioUseCase extends UseCase<RequestCommand<AgregarUbicacionUsuario>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarUbicacionUsuario> agregarUbicacionUsuarioRequestCommand) {
        var command = agregarUbicacionUsuarioRequestCommand.getCommand();

        var cuenta = Cuenta.from(
                command.getCuentaId(), repository().getEventsBy(command.getCuentaId().value())
        );
        cuenta.agregarUbicacionUsuario(command.getUbicacion());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
