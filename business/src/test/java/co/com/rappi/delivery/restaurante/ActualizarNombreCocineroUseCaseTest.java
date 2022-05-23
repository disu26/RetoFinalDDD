package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.commands.ActualizarNombreCocinero;
import co.com.rappi.delivery.restaurante.events.CocineroAgregado;
import co.com.rappi.delivery.restaurante.events.MenuAgregado;
import co.com.rappi.delivery.restaurante.events.NombreCocineroActualizado;
import co.com.rappi.delivery.restaurante.events.RestauranteCreado;
import co.com.rappi.delivery.restaurante.values.CocineroId;
import co.com.rappi.delivery.restaurante.values.MenuId;
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
class ActualizarNombreCocineroUseCaseTest {

    @InjectMocks
    private ActualizarNombreCocineroUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreCocineroHappyPass(){
        //Arrange
        RestauranteId restauranteId = RestauranteId.of("ddd");
        CocineroId cocineroId = CocineroId.of("dasd");
        Nombre nombre = new Nombre("María");
        var command = new ActualizarNombreCocinero(restauranteId, cocineroId, nombre);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRestauranteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (NombreCocineroActualizado)events.get(0);
        Assertions.assertEquals("dasd", event.getCocineroId().value());
        Assertions.assertEquals("María", event.getNombre().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Pasteur");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var event = new RestauranteCreado(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        CocineroId cocineroId = CocineroId.of("dasd");
        Nombre nombreCocinero = new Nombre("Pedro");
        var event2 = new CocineroAgregado(
                cocineroId, nombreCocinero
        );

        return List.of(event, event2);
    }
}