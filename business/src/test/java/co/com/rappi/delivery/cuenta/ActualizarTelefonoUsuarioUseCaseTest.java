package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.ActualizarTelefonoUsuario;
import co.com.rappi.delivery.cuenta.events.CuentaCreada;
import co.com.rappi.delivery.cuenta.events.TelefonoUsuarioActualizado;
import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.cuenta.values.UsuarioId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarTelefonoUsuarioUseCaseTest {

    @InjectMocks
    private ActualizarTelefonoUsuarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarTelefonoUsuarioHappyPass(){
        //Arrange
        CuentaId cuentaId = CuentaId.of("ddd");
        Telefono telefono = new Telefono("1235456");
        var command = new ActualizarTelefonoUsuario(cuentaId, telefono);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCuentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (TelefonoUsuarioActualizado)events.get(0);
        Assertions.assertEquals("1235456", event.getTelefono().value());
    }

    private List<DomainEvent> history(){
        UsuarioId usuarioId = new UsuarioId("dasd");
        Nombre nombre = new Nombre("Juan");
        Telefono telefono = new Telefono("456789");
        Usuario usuario = new Usuario(usuarioId, nombre, telefono);
        var event = new CuentaCreada(
                usuario
        );
        event.setAggregateRootId("dddd");
        return List.of(event);
    }
}