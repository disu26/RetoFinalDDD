package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.CocineroId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.sofka.domain.generic.Entity;

public class Cocinero extends Entity<CocineroId> {
    protected Plato plato;
    protected Nombre nombre;

    public Cocinero(CocineroId cocineroId, Nombre nombre) {
        super(cocineroId);
        this.nombre = nombre;
    }

    public void cocinarPlato(Plato plato){
        this.plato = plato;
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }
}
