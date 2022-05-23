package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class ActualizarNombreMenu extends Command {
    private final RestauranteId restauranteId;
    private final MenuId menuId;
    private final Nombre nombre;

    public ActualizarNombreMenu(RestauranteId restauranteId, MenuId menuId, Nombre nombre){
        this.restauranteId = restauranteId;
        this.menuId = menuId;
        this.nombre = nombre;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public MenuId getMenuId() {
        return menuId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}
