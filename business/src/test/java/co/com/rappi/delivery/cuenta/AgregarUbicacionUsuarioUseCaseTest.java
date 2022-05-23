package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.AgregarUbicacionUsuario;
import co.com.rappi.delivery.cuenta.events.CuentaCreada;
import co.com.rappi.delivery.cuenta.events.UbicacionUsuarioAgregada;
import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.cuenta.values.UsuarioId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.generic.values.Ubicacion;
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
class AgregarUbicacionUsuarioUseCaseTest {

    @InjectMocks
    private AgregarUbicacionUsuarioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUbicacionUsuarioHappyPass(){
        //Arrange
        CuentaId cuentaId = CuentaId.of("ddd");
        Ubicacion ubicacion = new Ubicacion("Antioquia", "Medellin", "Cra 80A");
        var command = new AgregarUbicacionUsuario(cuentaId, ubicacion);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCuentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (UbicacionUsuarioAgregada)events.get(0);
        Assertions.assertEquals(ubicacion, event.getUbicacion());
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