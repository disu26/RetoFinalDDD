package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.sofka.domain.generic.Command;

public final class ActualizarNombreUsuario extends Command {
    private final CuentaId cuentaId;
    private final Nombre nombre;

    public ActualizarNombreUsuario(CuentaId cuentaId, Nombre nombre){
        this.cuentaId = cuentaId;
        this.nombre = nombre;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
