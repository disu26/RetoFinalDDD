package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.values.EmpleadoId;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.sofka.domain.generic.Entity;

public class Empleado extends Entity<EmpleadoId> {
    protected Nombre nombre;
    protected ProductoId productoId;
    protected ServicioId servicioId;

    public Empleado(EmpleadoId empleadoId, Nombre nombre) {
        super(empleadoId);
        this.nombre = nombre;
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }

    public void despacharProducto(ProductoId productoId){
        this.productoId = productoId;
    }

    public void prestarServicio(ServicioId servicioId){
        this.servicioId = servicioId;
    }

}
