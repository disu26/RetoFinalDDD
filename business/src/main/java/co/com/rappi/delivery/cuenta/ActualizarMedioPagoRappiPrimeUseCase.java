package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.ActualizarMedioPagoRappiPrime;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class ActualizarMedioPagoRappiPrimeUseCase extends UseCase<RequestCommand<ActualizarMedioPagoRappiPrime>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarMedioPagoRappiPrime> actualizarMedioPagoRappiPrimeRequestCommand) {
        var command = actualizarMedioPagoRappiPrimeRequestCommand.getCommand();

        var cuenta = Cuenta.from(
                command.getCuentaId(), repository().getEventsBy(command.getCuentaId().value())
        );
        cuenta.actualizarMedioPagoRappiPrime(command.getMedioPago());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
