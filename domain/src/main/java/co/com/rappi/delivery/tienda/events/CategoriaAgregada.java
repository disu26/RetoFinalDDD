package co.com.rappi.delivery.tienda.events;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.sofka.domain.generic.DomainEvent;

public final class CategoriaAgregada extends DomainEvent {
    private final Categoria categoria;

    public CategoriaAgregada(Categoria categoria) {
        super("co.com.rappi.delivery.tienda.events.CategoriaAgregada");
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
