package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class MedioPago implements ValueObject<String> {
    private final String value;

    public MedioPago(String value) {
        this.value = Objects.requireNonNull(value);

        if (this.value.isBlank()){
            throw new IllegalArgumentException("El Medio de pago no puede estar en blanco");
        }

        if(this.value.length() > 100){
            throw new IllegalArgumentException("El medio de pago no permite más de 200 caracteres");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
