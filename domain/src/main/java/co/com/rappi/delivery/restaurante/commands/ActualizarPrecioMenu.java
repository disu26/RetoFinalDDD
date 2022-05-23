package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarPrecioMenu extends Command {
    private final RestauranteId restauranteId;
    private final MenuId menuId;
    private final Precio precio;

    public ActualizarPrecioMenu(RestauranteId restauranteId, MenuId menuId, Precio precio){
        this.restauranteId = restauranteId;
        this.menuId = menuId;
        this.precio = precio;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Precio getPrecio() {
        return precio;
    }
}
