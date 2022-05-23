package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.commands.ActualizarCostoEnvio;
import co.com.rappi.delivery.tienda.events.CostoEnvioActualizado;
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
class ActualizarCostoEnvioUseCaseTest {

    @InjectMocks
    private ActualizarCostoEnvioUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarCostoEnvioHappyPass(){
        //Arrange
        TiendaId tiendaId = TiendaId.of("ddd");
        CostoEnvio costoEnvio = new CostoEnvio(6500D);
        var command = new ActualizarCostoEnvio(tiendaId, costoEnvio);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getTiendaId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (CostoEnvioActualizado)events.get(0);
        Assertions.assertEquals(6500D, event.getCostoEnvio().value());
    }

    private List<DomainEvent> history(){
        Nombre nombre = new Nombre("Frisby");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var event = new TiendaCreada(
                nombre, costoEnvio
        );
        event.setAggregateRootId("dddd");

        return List.of(event);
    }
}