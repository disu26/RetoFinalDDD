package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.orden.commands.ActualizarDescripcionPqrs;
import co.com.rappi.delivery.orden.events.DescripcionPqrsActualizada;
import co.com.rappi.delivery.orden.events.FacturaGenerada;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.PqrsAgregado;
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
class ActualizarDescripcionPqrsUseCaseTest {

    @InjectMocks
    private ActualizarDescripcionPqrsUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void actualizarDescripconPqrsHappyPass(){
        OrdenId ordenId = OrdenId.of("dasd");
        Descripcion descripcion = new Descripcion("Producto En mal Estado");
        var command = new ActualizarDescripcionPqrs(ordenId, descripcion);

        when(repository.getEventsBy("dasd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (DescripcionPqrsActualizada)events.get(0);
        Assertions.assertEquals("Producto En mal Estado", event.getDescripcion().value());
    }

    private List<DomainEvent> history(){
        TiendaId tiendaId = TiendaId.of("dd");
        CuentaId cuentaId = CuentaId.of("ddd");
        var event = new OrdenTiendaCreada(
                tiendaId,
                cuentaId
        );
        event.setAggregateRootId("dddd");

        PqrsId pqrsId = PqrsId.of("fdasd");
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        Descripcion descripcion = new Descripcion("El producto me llegó incompleto");
        var event2 = new PqrsAgregado(
                pqrsId, descripcion, fecha
        );
        return List.of(event, event2);
    }
}