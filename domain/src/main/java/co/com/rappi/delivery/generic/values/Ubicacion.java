package co.com.rappi.delivery.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public final class Ubicacion implements ValueObject<Ubicacion.Props> {
    private final String departamento;
    private final String municipio;
    private final String direccion;

    public Ubicacion(String departamento, String municipio, String direccion) {
        this.departamento = Objects.requireNonNull(departamento);
        this.municipio = Objects.requireNonNull(municipio);
        this.direccion = Objects.requireNonNull(direccion);

        if(this.departamento.isBlank()){
            throw new IllegalArgumentException("El Departamento no puede estar en blanco");
        }

        if(this.municipio.isBlank()){
            throw new IllegalArgumentException("El Municipio no puede estar en blanco");
        }

        if(this.direccion.isBlank()){
            throw new IllegalArgumentException("La Dirección no puede estar en blanco");
        }

        if(this.departamento.length() > 50){
            throw new IllegalArgumentException("El departamento no permite más de 50 caracteres");
        }

        if(this.municipio.length() > 50){
            throw new IllegalArgumentException("El municipio no permite más de 50 caracteres");
        }
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String departamento() {
                return departamento;
            }

            @Override
            public String municipio() {
                return municipio;
            }

            @Override
            public String direccion() {
                return direccion;
            }
        };
    }

    public interface Props {
        String departamento();
        String municipio();
        String direccion();
    }
}
