package co.com.rappi.delivery.orden;

import co.com.rappi.delivery.orden.events.*;
import co.com.rappi.delivery.orden.values.Estado;
import co.com.sofka.domain.generic.EventChange;

public final class OrdenEventChange extends EventChange {
    public OrdenEventChange(Orden orden) {
        apply((OrdenRestauranteCreada event) -> {
            orden.restauranteId = event.getRestauranteId();
            orden.cuentaId = event.getCuentaId();
        });

        apply((OrdenTiendaCreada event) -> {
            orden.tiendaId = event.getTiendaId();
            orden.cuentaId = event.getCuentaId();
        });

        apply((OrdenRecibida event) -> orden.estado = new Estado(Estado.Estados.RECIBIDO));

        apply((OrdenPreparada event) -> orden.estado = new Estado(Estado.Estados.PREPARANDO));

        apply((LlevandoOrden event) -> orden.estado = new Estado(Estado.Estados.LLEVANDO));

        apply((OrdenEntregada event) -> orden.estado = new Estado(Estado.Estados.ENTREGADO));

        apply((FacturaGenerada event) -> {
            var facturaId = event.getFacturaId();
            orden.factura = new Factura(facturaId, event.getFecha(), event.getMedioPago(), event.getPropina());
        });

        apply((RappiTenderoAsignado event) -> {
            var rappiTenderoId = event.getRappiTenderoId();
            orden.rappiTendero = new RappiTendero(rappiTenderoId, event.getNombre(), event.getTelefono(),
                                                    event.getPropina());
        });

        apply((PqrsAgregado event) -> {
            var pqrsId = event.getPqrsId();
            orden.pqrs = new Pqrs(pqrsId, event.getDescripcion(), event.getFecha());
        });

        apply((DescripcionPqrsActualizada event) -> orden.pqrs.actualizarDescripcion(event.getDescripcion().value()));

        apply((RespuestaPqrsAgregado event) -> orden.pqrs.agregarRespuesta(event.getRespuesta()));

        apply((CalificacionRappiTenderoAgregada event) -> orden.rappiTendero.agregarCalificacion(event.getCalificacion()));

        apply((MedioPagoFacturaActualizado event) -> orden.factura.actualizarMedioPago(event.getMedioPago().value()));

        apply((PropinaFacturaActualizada event) -> orden.factura.actualizarPropina(event.getPropina().value()));

        apply((PropinaRappiTenderoActualizado event) -> orden.rappiTendero.actualizarPropina(event.getPropina().value()));

        apply((TotalPagarFacturaActualizado event) -> orden.factura.actualizarTotalPagar(event.getTotalPagar().value()));
    }
}
