package co.com.rappi.delivery.cuenta.events;

import co.com.rappi.delivery.cuenta.Usuario;
import co.com.sofka.domain.generic.DomainEvent;

public final class CuentaCreada extends DomainEvent {
    private final Usuario usuario;

    public CuentaCreada(Usuario usuario) {
        super("co.com.rappi.delivery.cuenta.events.CuentaCreada");
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
