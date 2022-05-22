package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.commands.AsignarRappiTendero;
import co.com.rappi.delivery.orden.events.OrdenPreparada;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.RappiTenderoAsignado;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
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
        var event = new OrdenPreparada(ordenId, nombre, telefono, propina);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getOrdenId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var rappiTenderoAsignado = (RappiTenderoAsignado)events.get(0);
        Assertions.assertEquals("Pedro", rappiTenderoAsignado.getNombre().value());
        Assertions.assertEquals("123456", rappiTenderoAsignado.getTelefono().value());
        Assertions.assertEquals(5000D, rappiTenderoAsignado.getPropina().value());
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