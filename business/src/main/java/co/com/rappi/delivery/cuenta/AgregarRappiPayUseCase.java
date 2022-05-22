package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.AgregarRappiPay;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarRappiPayUseCase extends UseCase<RequestCommand<AgregarRappiPay>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRappiPay> agregarRappiPayRequestCommand) {
        var command = agregarRappiPayRequestCommand.getCommand();

        var cuenta = Cuenta.from(
                command.getCuentaId(), repository().getEventsBy(command.getCuentaId().value())
        );
        cuenta.agregarRappiPay(command.getSaldo());

        emit().onResponse(new ResponseEvents(cuenta.getUncommittedChanges()));
    }
}
