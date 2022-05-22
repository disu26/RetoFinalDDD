package co.com.rappi.delivery;

import co.com.rappi.delivery.cuenta.Cuenta;
import co.com.rappi.delivery.cuenta.commands.CrearCuenta;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class CrearCuentaUseCase extends UseCase<RequestCommand<CrearCuenta>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCuenta> crearCuentaRequestCommand) {
        var command = crearCuentaRequestCommand.getCommand();

        var cuenta = new Cuenta(command.getCuentaId(), command.getUsuario());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
