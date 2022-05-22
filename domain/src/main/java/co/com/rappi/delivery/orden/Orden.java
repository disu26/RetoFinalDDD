package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.generic.values.Calificacion;
import co.com.rappi.delivery.generic.values.MedioPago;
import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.generic.values.Telefono;
import co.com.rappi.delivery.orden.events.*;
import co.com.rappi.delivery.orden.values.*;
import co.com.rappi.delivery.restaurante.values.RestauranteId;
import co.com.rappi.delivery.tienda.values.TiendaId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;

public class Orden extends AggregateEvent<OrdenId> {
    protected RestauranteId restauranteId;
    protected TiendaId tiendaId;
    protected CuentaId cuentaId;
    protected RappiTendero rappiTendero;
    protected Factura factura;
    protected Pqrs pqrs;
    protected Estado estado;

    public Orden(OrdenId ordenId, RestauranteId restauranteId, CuentaId cuentaId) {
        super(ordenId);
        appendChange(new OrdenRestauranteCreada(restauranteId, cuentaId)).apply();
        subscribe(new OrdenEventChange(this));
    }

    public Orden(OrdenId ordenId, TiendaId tiendaId, CuentaId cuentaId) {
        super(ordenId);
        appendChange(new OrdenTiendaCreada(tiendaId, cuentaId)).apply();
        subscribe(new OrdenEventChange(this));
    }

    private Orden(OrdenId ordenId){
        super(ordenId);
        subscribe(new OrdenEventChange(this));
    }

    public static Orden from(OrdenId ordenId, List<DomainEvent> events){
        var orden = new Orden(ordenId);
        events.forEach(orden::applyEvent);
        return orden;
    }

    public void generarFactura(Fecha fecha, MedioPago medioPago, Propina propina){
        var facturaId = new FacturaId();
        appendChange(new FacturaGenerada(facturaId, fecha, medioPago, propina));
    }

    public void asignarRappiTendero(Nombre nombre, Telefono telefono, Propina propina){
        var rappiTenderoId = new RappiTenderoId();
        appendChange(new RappiTenderoAsignado(rappiTenderoId, nombre, telefono, propina)).apply();
    }

    public void agregarPqrs(Descripcion descripcion, Fecha fecha){
        var pqrsId = new PqrsId();
        appendChange(new PqrsAgregado(pqrsId, descripcion, fecha)).apply();
    }

    public void actualizarDescripcionPqrs(Descripcion descripcion){
        appendChange(new DescripcionPqrsActualizada(descripcion)).apply();
    }

    public void agregarRespuestaPqrs(Respuesta respuesta){
        appendChange(new RespuestaPqrsAgregado(respuesta)).apply();
    }

    public void agregarCalificacionRappiTendero(Calificacion calificacion){
        appendChange(new CalificacionRappiTenderoAgregada(calificacion)).apply();
    }

    public void actualizarMedioPagoFactura(MedioPago medioPago){
        appendChange(new MedioPagoFacturaActualizado(medioPago)).apply();
    }

    public void actualizarPropinaFactura(Propina propina){
        appendChange(new PropinaFacturaActualizada(propina)).apply();
    }

    public void actualizarPropinaRappiTendero(Propina propina){
        appendChange(new PropinaRappiTenderoActualizado(propina)).apply();
    }

    public void actualizarTotalPagarFactura(TotalPagar totalPagar){
        appendChange(new TotalPagarFacturaActualizado(totalPagar)).apply();
    }

    public RestauranteId restauranteId() {
        return restauranteId;
    }

    public TiendaId tiendaId() {
        return tiendaId;
    }

    public CuentaId cuentaId() {
        return cuentaId;
    }

    public RappiTendero rappiTendero() {
        return rappiTendero;
    }

    public Factura factura() {
        return factura;
    }

    public Pqrs pqrs() {
        return pqrs;
    }

    public Estado estado() {
        return estado;
    }
}
