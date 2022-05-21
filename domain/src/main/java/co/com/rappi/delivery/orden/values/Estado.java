package co.com.rappi.delivery.orden.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Estado implements ValueObject<Estado.Estados> {
    private final Estados value;

    public Estado(Estados value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Estado.Estados value() {
        return value;
    }

    public enum Estados{
        RECIBIDO, PREPARANDO, LLEVANDO, ENTREGADO
    }
}
