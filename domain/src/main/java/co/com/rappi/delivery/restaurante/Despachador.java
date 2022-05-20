package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.values.DespachadorId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.sofka.domain.generic.Entity;

public class Despachador extends Entity<DespachadorId> {
    protected Nombre nombre;
    protected Plato plato;

    public Despachador(DespachadorId despachadorId, Nombre nombre) {
        super(despachadorId);
        this.nombre = nombre;
    }

    public void despacharPlato(Plato plato){
        this.plato = plato;
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }
}
