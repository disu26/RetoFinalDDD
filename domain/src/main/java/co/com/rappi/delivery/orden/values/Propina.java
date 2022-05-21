package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Propina implements ValueObject<Double> {
    private final Double value;

    public Propina(Double value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isNaN()){
            throw new IllegalArgumentException("Ingrese un valor válido");
        }

        if(this.value < 0){
            throw new IllegalArgumentException("La propina no puede ser negativa");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
