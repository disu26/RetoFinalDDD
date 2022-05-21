package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Descripcion implements ValueObject<String> {
    private final String value;

    public Descripcion(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()){
            throw new IllegalArgumentException("La Descripcion no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
