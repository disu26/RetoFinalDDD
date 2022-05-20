package co.com.rappi.delivery.cuenta.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Plan implements ValueObject<Plan.Planes> {
    private final Planes value;

    public Plan(Planes value) {
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Planes value() {
        return value;
    }

    public enum Planes {
        BASIC, PLUS
    }
}
