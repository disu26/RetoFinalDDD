package co.com.rappi.delivery.restaurante.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Plato implements ValueObject<Plato.Props> {
    private final String nombre;
    private final String descripcion;

    public Plato(String nombre, String descripcion) {
        this.nombre = Objects.requireNonNull(nombre);
        this.descripcion = Objects.requireNonNull(descripcion);

        if (this.nombre.isBlank()){
            throw new IllegalArgumentException("El Nombre no puede estar en blanco");
        }

        if(this.nombre.length() > 50){
            throw new IllegalArgumentException("El nombre no permite más de 50 caracteres");
        }
        if (this.descripcion.isBlank()){
            throw new IllegalArgumentException("La descripción no puede estar en blanco");
        }

        if(this.descripcion.length() > 200){
            throw new IllegalArgumentException("La descripción no permite más de 200 caracteres");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String nombre() {
                return nombre;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props{
        String nombre();
        String descripcion();
    }
}
