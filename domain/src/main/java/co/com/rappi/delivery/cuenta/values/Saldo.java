package co.com.rappi.delivery.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Saldo implements ValueObject<Double> {
    private final Double value;

    public Saldo(Double value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isNaN()){
            throw new IllegalArgumentException("Ingrese un valor válido");
        }
    }

    public Saldo actualizar(Double value){
        return new Saldo(this.value + value);
    }

    @Override
    public Double value() {
        return value;
    }

}
