package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Categoria implements ValueObject<String> {
    private final String value;

    public Categoria(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()){
            throw new IllegalArgumentException("La categoría no puede estar en blanco");
        }

        if(this.value.length() > 100){
            throw new IllegalArgumentException("La categoría no permite mas de 100 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
