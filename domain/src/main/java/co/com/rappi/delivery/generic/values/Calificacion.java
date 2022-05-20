package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Calificacion implements ValueObject<Integer> {
    private final Integer value;

    public Calificacion(Integer value) {
        this.value = Objects.requireNonNull(value);

        if(value < 0){
            throw new IllegalArgumentException("La calificación mínima es cero");
        }

        if(value > 5){
            throw new IllegalArgumentException("La calificación máxima es cinco");
        }
    }

    @Override
    public Integer value() {
        return value;
    }
}
