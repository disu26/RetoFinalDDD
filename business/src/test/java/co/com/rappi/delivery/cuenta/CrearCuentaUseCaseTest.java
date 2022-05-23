package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.commands.CrearCuenta;
import co.com.rappi.delivery.cuenta.events.CuentaCreada;
import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.cuenta.values.UsuarioId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrearCuentaUseCaseTest {

    private CrearCuentaUseCase useCase;

    @BeforeEach
    void setUp(){
        useCase = new CrearCuentaUseCase();
    }

    @Test
    void crearCuentaHappyPass(){
        //Arrange
        CuentaId cuentaId = CuentaId.of("dddd");
        UsuarioId usuarioId = new UsuarioId("dasd");
        Nombre nombre = new Nombre("Juan");
        Telefono telefono = new Telefono("456789");
        Usuario usuario = new Usuario(usuarioId, nombre, telefono);
        var command = new CrearCuenta(cuentaId, usuario);

        //Act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Asserts
        var cuentaCreada = (CuentaCreada)events.get(0);
        Assertions.assertEquals("dddd", cuentaCreada.aggregateRootId());
        Assertions.assertEquals(usuario, cuentaCreada.getUsuario());
    }
}