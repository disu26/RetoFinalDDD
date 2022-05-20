package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Precio implements ValueObject<Double> {
    private final Double value;

    public Precio(Double valor) {
        this.value = Objects.requireNonNull(valor);

        if(this.value.isNaN()){
            throw new IllegalArgumentException("Ingrese un valor válido");
        }

        if(this.value < 0){
            throw new IllegalArgumentException("El Precio no puede ser negativo");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
