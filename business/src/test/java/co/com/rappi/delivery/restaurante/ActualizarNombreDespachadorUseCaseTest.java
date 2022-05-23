package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.commands.ActualizarNombreDespachador;
import co.com.rappi.delivery.restaurante.events.DespachadorAgregado;
import co.com.rappi.delivery.restaurante.events.NombreDespachadorActualizado;
import co.com.rappi.delivery.restaurante.events.RestauranteCreado;
import co.com.rappi.delivery.restaurante.values.DespachadorId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
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
class ActualizarNombreDespachadorUseCaseTest {

    @InjectMocks
    private ActualizarNombreDespachadorUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreDespachadorHappyPass(){
        //Arrange
        RestauranteId restauranteId = RestauranteId.of("ddd");
        DespachadorId despachadorId = new DespachadorId("dasd");
        Nombre nombre = new Nombre("Alejandra");
        var command = new ActualizarNombreDespachador(restauranteId, despachadorId, nombre);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRestauranteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (NombreDespachadorActualizado)events.get(0);
        Assertions.assertEquals("dasd", event.getDespachadorId().value());
        Assertions.assertEquals("Alejandra", event.getNombre().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Pasteur");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var event = new RestauranteCreado(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        DespachadorId despachadorId = DespachadorId.of("dasd");
        Nombre nombreCocinero = new Nombre("Pedro");
        var event2 = new DespachadorAgregado(
                despachadorId, nombreCocinero
        );

        return List.of(event, event2);
    }
}