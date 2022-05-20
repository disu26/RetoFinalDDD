package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.values.UsuarioId;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.generic.values.Ubicacion;
import co.com.sofka.domain.generic.Entity;

import java.util.Set;

public class Usuario extends Entity<UsuarioId> {
    protected Nombre nombre;
    protected Set<Ubicacion> ubicaciones;
    protected Telefono telefono;

    public Usuario(UsuarioId usuarioId, Nombre nombre, Telefono telefono) {
        super(usuarioId);
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public void actualizarNombre(String nombre){
        this.nombre = new Nombre(nombre);
    }

    public void actualizarTelefono(String telefono){
        this.telefono = new Telefono(telefono);
    }

    public void agregarUbicacion(Ubicacion ubicacion){
        ubicaciones.add(ubicacion);
    }
}
