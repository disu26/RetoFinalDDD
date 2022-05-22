package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.Usuario;
import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.sofka.domain.generic.Command;

public final class CrearCuenta extends Command {
    private final CuentaId cuentaId;
    private final Usuario usuario;

    public CrearCuenta(CuentaId cuentaId, Usuario usuario){
        this.cuentaId = cuentaId;
        this.usuario = usuario;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
