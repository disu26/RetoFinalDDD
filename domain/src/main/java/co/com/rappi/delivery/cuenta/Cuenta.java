package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.events.*;
import co.com.rappi.delivery.cuenta.values.*;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Cuenta extends AggregateEvent<CuentaId> {
    protected Usuario usuario;
    protected RappiPay rappiPay;
    protected RappiPrime rappiPrime;

    public Cuenta(CuentaId cuentaId, Usuario usuario) {
        super(cuentaId);
        appendChange(new CuentaCreada(usuario)).apply();
        subscribe(new CuentaEventChange(this));
    }

    private Cuenta(CuentaId cuentaId){
        super(cuentaId);
        subscribe(new CuentaEventChange(this));
    }

    public static Cuenta from(CuentaId cuentaId, List<DomainEvent> events){
        var cuenta = new Cuenta(cuentaId);
        events.forEach(cuenta::applyEvent);
        return cuenta;
    }

    public void agregarRappiPay(Saldo saldo){
        var rappiPayId = new RappiPayId();
        appendChange(new RappiPayAgregado(rappiPayId, saldo)).apply();
    }

    public void agregarRappiPrime(Plan plan, MedioPago medioPago){
        var rappiPrimeId = new RappiPrimeId();
        appendChange(new RappiPrimeAgregado(rappiPrimeId, plan, medioPago)).apply();
    }

    public void actualizarPlanBasicoRappiPrime(){
        appendChange(new RappiPrimeActualizadoAPlanBasico()).apply();
    }

    public void actualizarPlanPlusRappiPrime(){
        appendChange(new RappiPrimeActualizadoAPlanPlus()).apply();
    }

    public void actualizarMedioPagoRappiPrime(MedioPago medioPago){
        appendChange(new MedioPagoRappiPrimeActualizado(medioPago)).apply();
    }

    public void actualizarNombreUsuario(Nombre nombre){
        appendChange(new NombreUsuarioActualizado(nombre)).apply();
    }

    public void agregarUbicacionUsuario(Ubicacion ubicacion){
        appendChange(new UbicacionUsuarioAgregada(ubicacion)).apply();
    }

    public void actualizarTelefonoUsuario(Telefono telefono){
        appendChange(new TelefonoUsuarioActualizado(telefono)).apply();
    }
}
