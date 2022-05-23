package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class AgregarPlatoMenu extends Command {
    private final RestauranteId restauranteId;
    private final MenuId menuId;
    private final Plato plato;

    public AgregarPlatoMenu(RestauranteId restauranteId, MenuId menuId, Plato plato){
        this.restauranteId = restauranteId;
        this.menuId = menuId;
        this.plato = plato;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Plato getPlato() {
        return plato;
    }
}
