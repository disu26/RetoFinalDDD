package co.com.rappi.delivery;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.commands.AsignarRappiTendero;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.RappiTenderoAsignado;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
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
class AsignarRappiTenderoUseCaseTest {

    @InjectMocks
    private AsignarRappiTenderoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void asignarRappiTenderoHappyPass(){
        //Arrange
        OrdenId ordenId = OrdenId.of("ddd");
        Nombre nombre = new Nombre("Pedro");
        Telefono telefono = new Telefono("123456");
        Propina propina = new Propina(5000D);
        var command = new AsignarRappiTendero(ordenId, nombre, telefono, propina);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (RappiTenderoAsignado)events.get(0);
        Assertions.assertEquals("Pedro", event.getNombre().value());
        Assertions.assertEquals("123456", event.getTelefono().value());
        Assertions.assertEquals(5000D, event.getPropina().value());
    }

    private List<DomainEvent> history(){
        TiendaId tiendaId = TiendaId.of("dd");
        CuentaId cuentaId = CuentaId.of("ddd");
        var event = new OrdenTiendaCreada(
                tiendaId,
                cuentaId
        );
        event.setAggregateRootId("dddd");
        return List.of(event);
    }
}