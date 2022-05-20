package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.tienda.events.*;
import co.com.rappi.delivery.tienda.values.EmpleadoId;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;
import java.util.HashSet;

public final class TiendaEventChange extends EventChange {
    public TiendaEventChange(Tienda tienda) {
        apply((TiendaCreada event) -> {
            tienda.nombre = event.getNombre();
            tienda.costoEnvio = event.getCostoEnvio();
            tienda.empleados = new HashMap<>();
            tienda.servicios = new HashMap<>();
            tienda.productos = new HashMap<>();
            tienda.ubicaciones = new HashSet<>();
            tienda.categorias = new HashSet<>();
        });

        apply((ProductoAgregado event) -> {
            var productoId = event.getProductoId();
            var producto = new Producto(productoId, event.getCategoria(), event.getPrecio(), event.getNombre());
            tienda.productos.put(productoId, producto);
        });

        apply((ServicioAgregado event) -> {
            var servicioId = event.getServicioId();
            var servicio = new Servicio(servicioId, event.getPrecio(), event.getNombre());
            tienda.servicios.put(servicioId, servicio);
        });

        apply((EmpleadoAgregado event) -> {
            var empleadoId = event.getEmpleadoId();
            var empleado = new Empleado(empleadoId, event.getNombre());
            tienda.empleados.put(empleadoId, empleado);
        });

        apply((NombreActualizado event) -> tienda.nombre = new Nombre(event.getNombre().value()));

        apply((CategoriaAgregada event) -> tienda.categorias.add(event.getCategoria()));

        apply((CalificacionActualizada event) -> tienda.calificacion = event.getCalificacion());

        apply((CostoEnvioActualizado event) -> tienda.costoEnvio = event.getCostoEnvio());

        apply((UbicacionAgregada event) -> tienda.ubicaciones.add(event.getUbicacion()));

        apply((CategoriaProductoActualizada event) -> tienda.productos.get(event.getProductoId())
                .actualizarCategoria(event.getCategoria().value()));

        apply((PrecioProductoActualizado event) -> tienda.productos.get(event.getProductoId())
                .actualizarPrecio(event.getPrecio().value()));

        apply((NombreProductoActualizado event) -> tienda.productos.get(event.getProductoId())
                .actualizarNombre(event.getNombre().value()));

        apply((NombreServicioActualizado event) -> tienda.servicios.get(event.getServicioId())
                .actualizarNombre(event.getNombre().value()));

        apply((PrecioServicioActualizado event) -> tienda.servicios.get(event.getServicioId())
                .actualizarPrecio(event.getPrecio().value()));

        apply((NombreEmpleadoActualizado event) -> tienda.empleados.get(event.getEmpleadoId())
                .actualizarNombre(event.getNombre().value()));

        apply((ProductoDespachadoEmpleado event) -> tienda.empleados.get(event.getEmpleadoId())
                .despacharProducto(event.getProductoId()));

        apply((ServicioPrestadoEmpleado event) -> tienda.empleados.get(event.getEmpleadoId())
                .prestarServicio(event.getServicioId()));
    }
}
