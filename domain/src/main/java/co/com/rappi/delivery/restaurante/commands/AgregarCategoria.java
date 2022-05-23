package co.com.rappi.delivery.restaurante.commands;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.sofka.domain.generic.Command;

public final class AgregarCategoria extends Command {
    private final RestauranteId restauranteId;
    private final Categoria categoria;

    public AgregarCategoria(RestauranteId restauranteId, Categoria categoria){
        this.restauranteId = restauranteId;
        this.categoria = categoria;
    }

    public RestauranteId getRestauranteId() {
        return restauranteId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
