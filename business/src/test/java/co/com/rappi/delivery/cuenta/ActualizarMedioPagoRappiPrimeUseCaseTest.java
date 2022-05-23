package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.ActualizarMedioPagoRappiPrime;
import co.com.rappi.delivery.cuenta.events.CuentaCreada;
import co.com.rappi.delivery.cuenta.events.MedioPagoRappiPrimeActualizado;
import co.com.rappi.delivery.cuenta.events.RappiPrimeAgregado;
import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.cuenta.values.Plan;
import co.com.rappi.delivery.cuenta.values.RappiPrimeId;
import co.com.rappi.delivery.cuenta.values.UsuarioId;
import co.com.rappi.delivery.generic.values.MedioPago;
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
class ActualizarMedioPagoRappiPrimeUseCaseTest {

    @InjectMocks
    private ActualizarMedioPagoRappiPrimeUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarMedioPagoRappiPrimeHappyPass(){
        //Arrange
        CuentaId cuentaId = CuentaId.of("ddd");
        MedioPago medioPago = new MedioPago("Tarjeta Crédito");
        var command = new ActualizarMedioPagoRappiPrime(cuentaId, medioPago);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getCuentaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (MedioPagoRappiPrimeActualizado)events.get(0);
        Assertions.assertEquals("Tarjeta Crédito", event.getMedioPago().value());
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

        RappiPrimeId rappiPrimeId = RappiPrimeId.of("dasdasd");
        Plan plan = new Plan(Plan.Planes.PLUS);
        MedioPago medioPago = new MedioPago("PSE");
        var event2 = new RappiPrimeAgregado(
                rappiPrimeId, plan, medioPago
        );

        return List.of(event, event2);
    }
}