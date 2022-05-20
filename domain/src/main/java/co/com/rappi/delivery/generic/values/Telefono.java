package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Telefono implements ValueObject<String> {
    private final String value;

    public Telefono(String value) {
        this.value = Objects.requireNonNull(value);

        if(this.value.isBlank()){
            throw new IllegalArgumentException("El Teléfono no puede estar en blanco");
        }

        if(this.value.length() > 20){
            throw new IllegalArgumentException("El Teléfono es demasiado largo");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
