package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.commands.ActualizarPropinaFactura;
import co.com.rappi.delivery.orden.commands.GenerarFactura;
import co.com.rappi.delivery.orden.events.FacturaGenerada;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.PropinaFacturaActualizada;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActualizarPropinaFacturaUseCaseTest {

    @InjectMocks
    private ActualizarPropinaFacturaUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarPropinaFacturaHappyPass(){
        OrdenId ordenId = OrdenId.of("dasd");
        Propina propina = new Propina(2000D);
        var command = new ActualizarPropinaFactura(ordenId, propina);

        when(repository.getEventsBy("dasd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (PropinaFacturaActualizada)events.get(0);
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

        FacturaId facturaId = FacturaId.of("dasdfas");
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        MedioPago medioPago = new MedioPago("Tarjeta");
        Propina propina = new Propina(2000D);
        var event2 = new FacturaGenerada(
                facturaId, fecha, medioPago, propina
        );
        return List.of(event, event2);
    }
}