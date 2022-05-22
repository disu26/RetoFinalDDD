package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class AgregarMenu extends Command {
    private final RestauranteId restauranteId;
    private final Nombre nombre;
    private final Precio precio;

    public AgregarMenu(RestauranteId restauranteId, Nombre nombre, Precio precio){
        this.restauranteId = restauranteId;
        this.nombre = nombre;
        this.precio = precio;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Precio getPrecio() {
        return precio;
    }
}
