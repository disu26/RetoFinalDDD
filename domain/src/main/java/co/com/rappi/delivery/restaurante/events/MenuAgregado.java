package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.sofka.domain.generic.DomainEvent;

public final class MenuAgregado extends DomainEvent {
    private final MenuId menuId;
    private final Nombre nombre;
    private final Precio precio;

    public MenuAgregado(MenuId menuId, Nombre nombre, Precio precio) {
        super("co.com.rappi.delivery.restaurante.events.DespachadorAgregado");
        this.menuId = menuId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
