package co.com.rappi.delivery.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Movimiento implements ValueObject<Movimiento.Props> {
    private final Double cantidad;
    private final String descripcion;

    public Movimiento(Double cantidad, String descripcion) {
        this.cantidad = Objects.requireNonNull(cantidad);
        this.descripcion = Objects.requireNonNull(descripcion);

        if(this.cantidad.isNaN()){
            throw new IllegalArgumentException("Ingrese un valor válido");
        }

        if(this.cantidad < 0){
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }

        if(this.descripcion.isBlank()){
            throw new IllegalArgumentException("La descripcion no puede estar vacía");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Double cantidad() {
                return cantidad;
            }

            @Override
            public String descripcion() {
                return descripcion;
            }
        };
    }

    public interface Props{
        Double cantidad();
        String descripcion();
    }
}
