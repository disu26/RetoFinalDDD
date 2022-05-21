package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class TotalPagar implements ValueObject<Double> {
    private final Double value;

    public TotalPagar(Double value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isNaN()){
            throw new IllegalArgumentException("Ingrese un valor válido");
        }

        if(this.value < 0){
            throw new IllegalArgumentException("El total a pagar no puede ser negativa");
        }
    }

    @Override
    public Double value() {
        return value;
    }
}
