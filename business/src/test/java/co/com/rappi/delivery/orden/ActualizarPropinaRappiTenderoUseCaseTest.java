package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.commands.ActualizarPropinaRappiTendero;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.PropinaRappiTenderoActualizado;
import co.com.rappi.delivery.orden.events.RappiTenderoAsignado;
import co.com.rappi.delivery.orden.values.*;
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
class ActualizarPropinaRappiTenderoUseCaseTest {

    @InjectMocks
    private ActualizarPropinaRappiTenderoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarPropinaRappiTenderoHappyPass(){
        OrdenId ordenId = OrdenId.of("dasd");
        Propina propina = new Propina(2000D);
        var command = new ActualizarPropinaRappiTendero(ordenId, propina);

        when(repository.getEventsBy("dasd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (PropinaRappiTenderoActualizado)events.get(0);
        Assertions.assertEquals(2000D, event.getPropina().value());
    }

    private List<DomainEvent> history(){
        TiendaId tiendaId = TiendaId.of("dd");
        CuentaId cuentaId = CuentaId.of("ddd");
        var event = new OrdenTiendaCreada(
                tiendaId,
                cuentaId
        );
        event.setAggregateRootId("dddd");

        RappiTenderoId rappiTenderoId = RappiTenderoId.of("dasdfas");
        Nombre nombre = new Nombre("Pedro");
        Telefono telefono = new Telefono("123456");
        Propina propina = new Propina(5000D);
        var event2 = new RappiTenderoAsignado(
                rappiTenderoId, nombre, telefono, propina
        );
        return List.of(event, event2);
    }
}