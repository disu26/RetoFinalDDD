package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.restaurante.values.MenuId;
import co.com.rappi.delivery.restaurante.values.Plato;
import co.com.sofka.domain.generic.Entity;

import java.util.HashSet;
import java.util.Set;

public class Menu extends Entity<MenuId> {
    protected Set<Plato> platos = new HashSet<>();
    protected Nombre nombre;
    protected Precio precio;

    public Menu(MenuId menuId, Nombre nombre, Precio precio) {
        super(menuId);
        this.nombre = nombre;
        this.precio = precio;
    }

    public void agregarPlato(Plato plato){
        this.platos.add(plato);
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }

    public void actualizarPrecio(Double precio){
        this.precio = new Precio(precio);
    }
}
