package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.sofka.domain.generic.Entity;

public class Servicio extends Entity<ServicioId> {
    protected Precio precio;
    protected Nombre nombre;

    public Servicio(ServicioId servicioId, Precio precio, Nombre nombre) {
        super(servicioId);
        this.precio = precio;
        this.nombre = nombre;
    }

    public void actualizarPrecio(Double precio){
        this.precio = new Precio(precio);
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }
}
