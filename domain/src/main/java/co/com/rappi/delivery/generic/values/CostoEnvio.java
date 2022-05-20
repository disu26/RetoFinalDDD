package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class CostoEnvio implements ValueObject<Double> {
    private final Double value;

    public CostoEnvio(Double value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isNaN()){
            throw new IllegalArgumentException("Ingrese un valor válido");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
