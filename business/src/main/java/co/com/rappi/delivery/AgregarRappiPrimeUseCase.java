package co.com.rappi.delivery;

import co.com.rappi.delivery.cuenta.Cuenta;
import co.com.rappi.delivery.cuenta.commands.AgregarRappiPrime;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarRappiPrimeUseCase extends UseCase<RequestCommand<AgregarRappiPrime>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRappiPrime> agregarRappiPrimeRequestCommand) {
        var command = agregarRappiPrimeRequestCommand.getCommand();

        var cuenta = Cuenta.from(
                command.getCuentaId(), repository().getEventsBy(command.getCuentaId().value())
        );
        cuenta.agregarRappiPrime(command.getPlan(), command.getMedioPago());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
