package co.com.rappi.delivery.tienda;

import co.com.rappi.delivery.generic.values.Categoria;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Precio;
import co.com.rappi.delivery.tienda.values.ProductoId;
import co.com.sofka.domain.generic.Entity;

public class Producto extends Entity<ProductoId> {
    protected Categoria categoria;
    protected Precio precio;
    protected Nombre nombre;

    public Producto(ProductoId productoId, Categoria categoria, Precio precio, Nombre nombre) {
        super(productoId);
        this.categoria = categoria;
        this.precio = precio;
        this.nombre = nombre;
    }

    public void actualizarCategoria(String categoria){
        this.categoria = new Categoria(categoria);
    }

    public void actualizarPrecio(Double precio){
        this.precio = new Precio(precio);
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }
}
