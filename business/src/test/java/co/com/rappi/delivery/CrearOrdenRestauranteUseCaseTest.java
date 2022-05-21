package co.com.rappi.delivery;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.orden.commands.CrearOrdenRestaurante;
import co.com.rappi.delivery.orden.events.OrdenRestauranteCreada;
import co.com.rappi.delivery.orden.values.*;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearOrdenRestauranteUseCaseTest {

    private CrearOrdenRestauranteUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new CrearOrdenRestauranteUseCase();
    }

    @Test
    public void crearOrdenRestauranteHappyPass(){
        //Arrange
        OrdenId ordenId = OrdenId.of("dddd");
        RestauranteId restauranteId = RestauranteId.of("dd");
        CuentaId cuentaId = CuentaId.of("ddd");
        var command = new CrearOrdenRestaurante(ordenId, restauranteId, cuentaId);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var ordenCreada = (OrdenRestauranteCreada)events.get(0);
        Assertions.assertEquals("dddd", ordenCreada.aggregateRootId());
        Assertions.assertEquals("dd", ordenCreada.getRestauranteId().value());
        Assertions.assertEquals("ddd", ordenCreada.getCuentaId().value());
    }
}