package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.sofka.domain.generic.DomainEvent;

public final class PrecioMenuActualizado extends DomainEvent {
    private final MenuId menuId;
    private final Precio precio;

    public PrecioMenuActualizado(MenuId menuId, Precio precio) {
        super("co.com.rappi.delivery.restaurante.events.PrecioMenuActualizado");
        this.menuId = menuId;
        this.precio = precio;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
