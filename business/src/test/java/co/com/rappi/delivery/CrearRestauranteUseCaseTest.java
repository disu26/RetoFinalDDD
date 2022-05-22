package co.com.rappi.delivery;

import co.com.rappi.delivery.generic.values.CostoEnvio;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.commands.CrearRestaurante;
import co.com.rappi.delivery.restaurante.events.RestauranteCreado;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearRestauranteUseCaseTest {

    private CrearRestauranteUseCase useCase;

    @BeforeEach
    void  setUp(){
        useCase = new CrearRestauranteUseCase();
    }

    @Test
    void crearRestauranteHappyPass(){
        //Arrange
        RestauranteId restauranteId = RestauranteId.of("dddd");
        Nombre nombre = new Nombre("Frisby");
        CostoEnvio costoEnvio = new CostoEnvio(5000D);
        var command = new CrearRestaurante(restauranteId, nombre, costoEnvio);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var restauranteCreado = (RestauranteCreado)events.get(0);
        Assertions.assertEquals("dddd", restauranteCreado.aggregateRootId());
        Assertions.assertEquals("Frisby", restauranteCreado.getNombre().value());
        Assertions.assertEquals(5000D, restauranteCreado.getCostoEnvio().value());
    }
}