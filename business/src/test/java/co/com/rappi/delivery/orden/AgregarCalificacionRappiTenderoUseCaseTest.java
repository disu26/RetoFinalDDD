package co.com.rappi.delivery.orden;


import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.commands.AsignarRappiTendero;
import co.com.rappi.delivery.orden.events.CalificacionRappiTenderoAgregada;
import co.com.rappi.delivery.orden.events.OrdenEntregada;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.RappiTenderoAsignado;
import co.com.rappi.delivery.orden.values.Estado;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.rappi.delivery.orden.values.RappiTenderoId;
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
class AgregarCalificacionRappiTenderoUseCaseTest {

    @InjectMocks
    private AgregarCalificacionRappiTenderoUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarCalificacionRappiTendero(){
        OrdenId ordenId = OrdenId.of("dasd");
        Calificacion calificacion = new Calificacion(4);
        var event = new OrdenEntregada(ordenId, calificacion);

        when(repository.getEventsBy("dasd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(event.getOrdenId().value())
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var calificacionAgregada = (CalificacionRappiTenderoAgregada)events.get(0);
        Assertions.assertEquals(4 , calificacionAgregada.getCalificacion().value());
    }

    private List<DomainEvent> history(){
        OrdenId ordenId = OrdenId.of("dddd");
        TiendaId tiendaId = TiendaId.of("dd");
        CuentaId cuentaId = CuentaId.of("ddd");
        var event = new OrdenTiendaCreada(
                tiendaId,
                cuentaId
        );
        event.setAggregateRootId(ordenId.value());

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