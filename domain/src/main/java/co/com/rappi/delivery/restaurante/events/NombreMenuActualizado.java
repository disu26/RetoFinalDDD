package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.sofka.domain.generic.DomainEvent;

public final class NombreMenuActualizado extends DomainEvent {
    private final MenuId menuId;
    private final Nombre nombre;

    public NombreMenuActualizado(MenuId menuId, Nombre nombre) {
        super("co.com.rappi.delivery.restaurante.events.ActualizarNombreMenu");
        this.menuId = menuId;
        this.nombre = nombre;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
