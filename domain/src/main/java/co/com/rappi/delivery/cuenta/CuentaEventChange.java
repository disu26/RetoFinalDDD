package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.events.*;
import co.com.sofka.domain.generic.EventChange;

public final class CuentaEventChange extends EventChange {
    public CuentaEventChange(Cuenta cuenta) {
        apply((CuentaCreada event) -> cuenta.usuario = event.getUsuario());

        apply((RappiPayAgregado event) -> {
            var rappiPayId = event.getRappiPayId();
            cuenta.rappiPay = new RappiPay(rappiPayId, event.getSaldo());
        });

        apply((RappiPrimeAgregado event) -> {
            var rappiPrimeId = event.getRappiPrimeId();
            cuenta.rappiPrime = new RappiPrime(rappiPrimeId, event.getPlan(), event.getMedioPago());
        });

        apply((RappiPrimeActualizadoAPlanBasico event) -> cuenta.rappiPrime.actualizarPlanBasico());

        apply((RappiPrimeActualizadoAPlanBasico event) -> cuenta.rappiPrime.actualizarPlanPlus());

        apply((MedioPagoRappiPrimeActualizado event) -> cuenta.rappiPrime
                .actualizarMedioPago(event.getMedioPago().value()));

        apply((NombreUsuarioActualizado event) -> cuenta.usuario
                .actualizarNombre(event.getNombre().value()));

        apply((UbicacionUsuarioAgregada event) -> cuenta.agregarUbicacionUsuario(event.getUbicacion()));

        apply((TelefonoUsuarioActualizado event) -> cuenta.usuario
                .actualizarTelefono(event.getTelefono().value()));
    }
}
