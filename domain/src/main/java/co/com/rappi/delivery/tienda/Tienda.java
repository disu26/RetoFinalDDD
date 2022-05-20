package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.*;
import co.com.rappi.delivery.tienda.events.*;
import co.com.rappi.delivery.tienda.values.EmpleadoId;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.rappi.delivery.tienda.values.ServicioId;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tienda extends AggregateEvent<TiendaId> {
    protected Map<ProductoId, Producto> productos;
    protected Map<ServicioId, Servicio> servicios;
    protected Map<EmpleadoId, Empleado> empleados;
    protected Nombre nombre;
    protected Calificacion calificacion;
    protected Set<Categoria> categorias;
    protected Set<Ubicacion> ubicaciones;
    protected CostoEnvio costoEnvio;

    public Tienda(TiendaId tiendaId, Nombre nombre, CostoEnvio costoEnvio) {
        super(tiendaId);
        appendChange(new TiendaCreada(nombre, costoEnvio)).apply();
        subscribe(new TiendaEventChange(this));
    }

    private Tienda(TiendaId tiendaId){
        super(tiendaId);
        subscribe(new TiendaEventChange(this));
    }

    public static Tienda from(TiendaId tiendaId, List<DomainEvent> events){
        var tienda = new Tienda(tiendaId);
        events.forEach(tienda::applyEvent);
        return tienda;
    }

    public void agregarProducto(Categoria categoria, Precio precio, Nombre nombre){
        var productoId = new ProductoId();
        appendChange(new ProductoAgregado(productoId, categoria, precio, nombre)).apply();
    }

    public void agregarServicio(Nombre nombre, Precio precio){
        var servicioId = new ServicioId();
        appendChange(new ServicioAgregado(servicioId, nombre, precio)).apply();
    }

    public void agregarEmpleado(Nombre nombre){
        var empleadoId = new EmpleadoId();
        appendChange(new EmpleadoAgregado(empleadoId, nombre)).apply();
    }

    public void actualizarNombre(Nombre nombre){
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void agregarCategoria(Categoria categoria){
        appendChange(new CategoriaAgregada(categoria)).apply();
    }

    public void actualizarCalificacion(Calificacion calificacion){
        appendChange(new CalificacionActualizada(calificacion)).apply();
    }

    public void actualiazarCostoEnvio(CostoEnvio costoEnvio){
        appendChange(new CostoEnvioActualizado(costoEnvio)).apply();
    }

    public void agregarUbicacion(Ubicacion ubicacion){
        appendChange(new UbicacionAgregada(ubicacion)).apply();
    }

    public void actualizarCategoriaProducto(ProductoId productoId, Categoria categoria){
        appendChange(new CategoriaProductoActualizada(productoId, categoria)).apply();
    }

    public void actualizarPrecioProducto(ProductoId productoId, Precio precio){
        appendChange(new PrecioProductoActualizado(productoId, precio)).apply();
    }

    public void actualizarNombreProducto(ProductoId productoId, Nombre nombre){
        appendChange(new NombreProductoActualizado(productoId, nombre)).apply();
    }

    public void actualizarNombreServicio(ServicioId servicioId, Nombre nombre){
        appendChange(new NombreServicioActualizado(servicioId, nombre)).apply();
    }

    public void actualizarPrecioServicio(ServicioId servicioId, Precio precio){
        appendChange(new PrecioServicioActualizado(servicioId, precio)).apply();
    }

    public void actualizarNombreEmpleado(EmpleadoId empleadoId, Nombre nombre){
        appendChange(new NombreEmpleadoActualizado(empleadoId, nombre)).apply();
    }

    public void despacharProductoEmpleado(EmpleadoId empleadoId, ProductoId productoId){
        appendChange(new ProductoDespachadoEmpleado(empleadoId, productoId)).apply();
    }

    public void prestarServicioEmpleado(EmpleadoId empleadoId, ServicioId servicioId){
        appendChange(new ServicioPrestadoEmpleado(empleadoId, servicioId)).apply();
    }
}
