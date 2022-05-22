package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.commands.AgregarEmpleado;
import co.com.rappi.delivery.tienda.events.EmpleadoAgregado;
import co.com.rappi.delivery.tienda.events.TiendaCreada;
import co.com.rappi.delivery.tienda.values.TiendaId;
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
class AgregarEmpleadoUseCaseTest {

    @InjectMocks
    private AgregarEmpleadoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarEmpleadoHappyPass(){
        //Arrange
        TiendaId tiendaId = TiendaId.of("ddd");
        Nombre nombre = new Nombre("Pedro");
        var command = new AgregarEmpleado(tiendaId, nombre);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (EmpleadoAgregado)events.get(0);
        Assertions.assertEquals("Pedro", event.getNombre().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Drogueria Pasteur");
        CostoEnvio costoEnvio = new CostoEnvio(4000D);
        var event = new TiendaCreada(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        return List.of(event);
    }
}