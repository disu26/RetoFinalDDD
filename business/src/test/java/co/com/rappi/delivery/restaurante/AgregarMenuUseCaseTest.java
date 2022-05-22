package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.AgregarMenuUseCase;
import co.com.rappi.delivery.restaurante.commands.AgregarMenu;
import co.com.rappi.delivery.restaurante.events.MenuAgregado;
import co.com.rappi.delivery.restaurante.events.RestauranteCreado;
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
class AgregarMenuUseCaseTest{

    @InjectMocks
    private AgregarMenuUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarMenuHappyPass(){
        //Arrange
        RestauranteId restauranteId = RestauranteId.of("ddd");
        Nombre nombre = new Nombre("Explosión de Sabor");
        Precio precio = new Precio(42000D);
        var command = new AgregarMenu(restauranteId, nombre, precio);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRestauranteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (MenuAgregado)events.get(0);
        Assertions.assertEquals("Explosión de Sabor", event.getNombre().value());
        Assertions.assertEquals(42000D, event.getPrecio().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Frisby");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var event = new RestauranteCreado(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        return List.of(event);
    }
}