package co.com.rappi.delivery.restaurante.events;

import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.sofka.domain.generic.DomainEvent;

public final class PlatoAgregadoMenu extends DomainEvent {
    private final MenuId menuId;
    private final Plato plato;

    public PlatoAgregadoMenu(MenuId menuId, Plato plato) {
        super("co.com.rappi.delivery.restaurante.events.PlatoAgregadoMenu");
        this.menuId = menuId;
        this.plato = plato;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Plato getPlato() {
        return plato;
    }
}
