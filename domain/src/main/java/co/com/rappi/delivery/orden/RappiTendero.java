package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.rappi.delivery.orden.values.RappiTenderoId;
import co.com.sofka.domain.generic.Entity;

public class RappiTendero extends Entity<RappiTenderoId> {
    protected Nombre nombre;
    protected Calificacion calificacion;
    protected Telefono telefono;
    protected Propina propina;

    public RappiTendero(RappiTenderoId rappiTenderoId, Nombre nombre, Telefono telefono, Propina propina) {
        super(rappiTenderoId);
        this.nombre = nombre;
        this.telefono = telefono;
        this.propina = propina;
    }

    public void agregarCalificacion(Calificacion calificacion){
        this.calificacion = calificacion;
    }

    public void actualizarPropina(Double propina){
        this.propina = new Propina(propina);
    }
}
