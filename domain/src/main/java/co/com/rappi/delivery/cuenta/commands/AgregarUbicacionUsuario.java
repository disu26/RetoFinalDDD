package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.sofka.domain.generic.Command;

public final class AgregarUbicacionUsuario extends Command {
    private final CuentaId cuentaId;
    private final Ubicacion ubicacion;

    public AgregarUbicacionUsuario(CuentaId cuentaId, Ubicacion ubicacion){
        this.cuentaId = cuentaId;
        this.ubicacion = ubicacion;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }
}
