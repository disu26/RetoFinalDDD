package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.sofka.domain.generic.Command;

public final class ActualizarTelefonoUsuario extends Command {
    private final CuentaId cuentaId;
    private final Telefono telefono;

    public ActualizarTelefonoUsuario(CuentaId cuentaId, Telefono telefono){
        this.cuentaId = cuentaId;
        this.telefono = telefono;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Telefono getTelefono() {
        return telefono;
    }
}
