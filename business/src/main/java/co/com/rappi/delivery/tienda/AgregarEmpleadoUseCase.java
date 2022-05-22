package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.tienda.commands.AgregarEmpleado;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public final class AgregarEmpleadoUseCase extends UseCase<RequestCommand<AgregarEmpleado>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarEmpleado> agregarEmpleadoRequestCommand) {
        var command = agregarEmpleadoRequestCommand.getCommand();

        var tienda = Tienda.from(
                command.getTiendaId(), repository().getEventsBy(command.getTiendaId().value())
        );
        tienda.agregarEmpleado(command.getNombre());

        emit().onResponse(new ResponseEvents(tienda.getUncommittedChanges()));
    }
}
