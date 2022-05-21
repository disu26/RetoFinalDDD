package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.orden.values.FacturaId;
import co.com.rappi.delivery.orden.values.Fecha;
import co.com.rappi.delivery.orden.values.Propina;
import co.com.rappi.delivery.orden.values.TotalPagar;
import co.com.sofka.domain.generic.Entity;

public class Factura extends Entity<FacturaId> {
    protected Propina propina;
    protected TotalPagar totalPagar;
    protected Fecha fecha;
    protected MedioPago medioPago;

    public Factura(FacturaId facturaId, Fecha fecha, MedioPago medioPago, Propina propina) {
        super(facturaId);
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.propina = propina;
    }

    public void actualizarMedioPago(String medioPago){
        this.medioPago = new MedioPago(medioPago);
    }

    public void actualizarPropina(Double propina){
        this.propina = new Propina(propina);
    }

    public void actualizarTotalPagar(Double totalPagar){
        this.totalPagar = new TotalPagar(totalPagar);
    }

}
