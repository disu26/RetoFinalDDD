package co.com.rappi.delivery;


import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.commands.AgregarProducto;
import co.com.rappi.delivery.tienda.commands.CrearTienda;
import co.com.rappi.delivery.tienda.events.ProductoAgregado;
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
class AgregarProductoUseCaseTest {

    @InjectMocks
    private  AgregarProductoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarProductoHappyPass(){
        //Arrange
        TiendaId tiendaId = TiendaId.of("ddd");
        Categoria categoria = new Categoria("Bebida");
        Precio precio = new Precio(5000D);
        Nombre nombre = new Nombre("Gaseosa");
        var command = new AgregarProducto(tiendaId, categoria, precio, nombre);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (ProductoAgregado)events.get(0);
        Assertions.assertEquals("Bebida", event.getCategoria().value());
        Assertions.assertEquals(5000D, event.getPrecio().value());
        Assertions.assertEquals("Gaseosa", event.getNombre().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Exito");
        CostoEnvio costoEnvio = new CostoEnvio(4000D);
        var event = new TiendaCreada(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        return List.of(event);
    }
}