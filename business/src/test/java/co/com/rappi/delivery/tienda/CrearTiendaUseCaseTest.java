package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.CrearTiendaUseCase;
import co.com.rappi.delivery.tienda.commands.CrearTienda;
import co.com.rappi.delivery.tienda.events.TiendaCreada;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearTiendaUseCaseTest {

    private CrearTiendaUseCase useCase;

    @BeforeEach
    void  setUp(){
        useCase = new CrearTiendaUseCase();
    }

    @Test
    void crearTiendaHappyPass(){
        //Arrange
        TiendaId tiendaId = TiendaId.of("dddd");
        Nombre nombre = new Nombre("Exito");
        CostoEnvio costoEnvio = new CostoEnvio(4000D);
        var command = new CrearTienda(tiendaId, nombre, costoEnvio);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var tiendaCreada = (TiendaCreada)events.get(0);
        Assertions.assertEquals("dddd", tiendaCreada.aggregateRootId());
        Assertions.assertEquals("Exito", tiendaCreada.getNombre().value());
        Assertions.assertEquals(4000D, tiendaCreada.getCostoEnvio().value());
    }
}