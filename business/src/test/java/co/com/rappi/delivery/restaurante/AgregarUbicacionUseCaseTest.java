package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.rappi.delivery.restaurante.commands.AgregarUbicacion;
import co.com.rappi.delivery.restaurante.events.RestauranteCreado;
import co.com.rappi.delivery.restaurante.events.UbicacionAgregada;
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
class AgregarUbicacionUseCaseTest {

    @InjectMocks
    private AgregarUbicacionUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarUbicacionHappyPass(){
        //Arrange
        RestauranteId restauranteId = RestauranteId.of("ddd");
        Ubicacion ubicacion = new Ubicacion("Antioquia", "Medellin", "Cra 80A");
        var command = new AgregarUbicacion(restauranteId, ubicacion);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRestauranteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (UbicacionAgregada)events.get(0);
        Assertions.assertEquals(ubicacion, event.getUbicacion());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Pasteur");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var event = new RestauranteCreado(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        return List.of(event);
    }
}