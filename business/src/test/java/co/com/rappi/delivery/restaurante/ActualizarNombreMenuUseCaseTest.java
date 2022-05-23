package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.commands.ActualizarNombreMenu;
import co.com.rappi.delivery.restaurante.events.MenuAgregado;
import co.com.rappi.delivery.restaurante.events.NombreMenuActualizado;
import co.com.rappi.delivery.restaurante.events.RestauranteCreado;
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
class ActualizarNombreMenuUseCaseTest {

    @InjectMocks
    private ActualizarNombreMenuUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarNombreMenuHappyPass(){
        //Arrange
        RestauranteId restauranteId = RestauranteId.of("ddd");
        MenuId menuId = MenuId.of("dasd");
        Nombre nombre = new Nombre("Pasta Napolitana");
        var command = new ActualizarNombreMenu(restauranteId, menuId , nombre);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getRestauranteId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (NombreMenuActualizado)events.get(0);
        Assertions.assertEquals("dasd", event.getMenuId().value());
        Assertions.assertEquals("Pasta Napolitana", event.getNombre().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Pasteur");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var event = new RestauranteCreado(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        MenuId menuId = MenuId.of("dasd");
        Nombre nombreMenu = new Nombre("Explosión de Sabor");
        Precio precio = new Precio(42000D);
        var event2 = new MenuAgregado(
                menuId, nombreMenu, precio
        );

        return List.of(event, event2);
    }
}