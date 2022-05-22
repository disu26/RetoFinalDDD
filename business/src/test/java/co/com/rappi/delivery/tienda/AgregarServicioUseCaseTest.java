package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.commands.AgregarServicio;
import co.com.rappi.delivery.tienda.events.ServicioAgregado;
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
class AgregarServicioUseCaseTest {

    @InjectMocks
    private AgregarServicioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarServicioHappyPass(){
        //Arrange
        TiendaId tiendaId = TiendaId.of("ddd");
        Nombre nombre = new Nombre("Vacunacion");
        Precio precio = new Precio(7000D);
        var command = new AgregarServicio(tiendaId, nombre, precio);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (ServicioAgregado)events.get(0);
        Assertions.assertEquals("Vacunacion", event.getNombre().value());
        Assertions.assertEquals(7000D, event.getPrecio().value());
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