package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Respuesta implements ValueObject<String> {
    private final String value;

    public Respuesta(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()){
            throw new IllegalArgumentException("La Respuesta no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
