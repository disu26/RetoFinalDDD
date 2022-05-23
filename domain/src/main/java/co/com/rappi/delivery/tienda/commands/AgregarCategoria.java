package co.com.rappi.delivery.tienda.commands;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.Command;

public final class AgregarCategoria extends Command {
    private final TiendaId tiendaId;
    private final Categoria categoria;

    public AgregarCategoria(TiendaId tiendaId, Categoria categoria){
        this.tiendaId = tiendaId;
        this.categoria = categoria;
    }

    public TiendaId getTiendaId() {
        return tiendaId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
