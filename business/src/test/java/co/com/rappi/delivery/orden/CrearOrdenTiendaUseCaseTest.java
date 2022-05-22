package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.orden.CrearOrdenTiendaUseCase;
import co.com.rappi.delivery.orden.commands.CrearOrdenTienda;
import co.com.rappi.delivery.orden.events.OrdenTiendaCreada;
import co.com.rappi.delivery.orden.values.OrdenId;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearOrdenTiendaUseCaseTest {

    private CrearOrdenTiendaUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearOrdenTiendaUseCase();
    }

    @Test
    void crearOrdenTiendaHappyPass(){
        //Arrange
        OrdenId ordenId = OrdenId.of("dddd");
        TiendaId tiendaId = TiendaId.of("dd");
        CuentaId cuentaId = CuentaId.of("ddd");
        var command = new CrearOrdenTienda(ordenId, tiendaId, cuentaId);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var ordenCreada = (OrdenTiendaCreada)events.get(0);
        Assertions.assertEquals("dddd", ordenCreada.aggregateRootId());
        Assertions.assertEquals("dd", ordenCreada.getTiendaId().value());
        Assertions.assertEquals("ddd", ordenCreada.getCuentaId().value());
    }
}