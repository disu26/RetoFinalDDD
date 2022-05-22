package co.com.rappi.delivery;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.orden.commands.AgregarPqrs;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.events.PqrsAgregado;
import co.com.rappi.delivery.orden.values.Descripcion;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.OrdenId;
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
class AgregarPqrsUseCaseTest {

    @InjectMocks
    private AgregarPqrsUseCase useCase;

    @Mock
    private DomainEventRepository repository;

    @Test
    void agregarPqrsHappyPass(){
        //Arrange
        OrdenId ordenId = OrdenId.of("ddd");
        Fecha fecha = new Fecha(LocalDateTime.now(), LocalDate.now());
        Descripcion descripcion = new Descripcion("El producto me llegó incompleto");
        var command = new AgregarPqrs(ordenId, descripcion, fecha);

        when(repository.getEventsBy("ddd")).thenReturn(history());
        useCase.addRepository(repository);

        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(command.getOrdenId().value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var event = (PqrsAgregado)events.get(0);
        Assertions.assertEquals("El producto me llegó incompleto", event.getDescripcion().value());
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