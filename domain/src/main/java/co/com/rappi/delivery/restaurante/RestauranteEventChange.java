package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.generic.values.Nombre;
import co.com.rappi.delivery.restaurante.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashMap;
import java.util.HashSet;

public final class RestauranteEventChange extends EventChange {
    public RestauranteEventChange(Restaurante restaurante) {
        apply((RestauranteCreado event) -> {
            restaurante.nombre = event.getNombre();
            restaurante.costoEnvio = event.getCostoEnvio();
            restaurante.despachadores = new HashMap<>();
            restaurante.cocineros = new HashMap<>();
            restaurante.menus = new HashMap<>();
            restaurante.ubicaciones = new HashSet<>();
            restaurante.categorias = new HashSet<>();
        });

        apply((DespachadorAgregado event) -> {
            var despachadorId = event.getDespachadorId();
            var despachador = new Despachador(despachadorId, event.getNombre());
            restaurante.despachadores.put(despachadorId, despachador);
        });

        apply((NombreActualizado event) -> restaurante.nombre = new Nombre(event.getNombre().value()));

        apply((CategoriaAgregada event) -> restaurante.categorias.add(event.getCategoria()));

        apply((CalificacionActualizada event) -> restaurante.calificacion = event.getCalificacion());

        apply((CostoEnvioActualizado event) -> restaurante.costoEnvio = event.getCostoEnvio());

        apply((UbicacionAgregada event) -> restaurante.ubicaciones.add(event.getUbicacion()));

        apply((PlatoAgregadoMenu event) -> restaurante.menus.get(event.getMenuId()).platos.add(event.getPlato()));

        apply((NombreMenuActualizado event) -> restaurante.menus.get(event.getMenuId())
                .actualizarNombre(event.getNombre().value()));

        apply((PrecioMenuActualizado event) -> restaurante.menus.get(event.getMenuId())
                .actualizarPrecio(event.getPrecio().value()));

        apply((PlatoDespachadoDespachador event) -> restaurante.despachadores.get(event.getDespachadorId())
                .despacharPlato(event.getPlato()));

        apply((NombreDespachadorActualizado event) -> restaurante.despachadores.get(event.getDespachadorId())
                .actualizarNombre(event.getNombre().value()));

        apply((NombreCocineroActualizado event) -> restaurante.cocineros.get(event.getCocineroId())
                .actualizarNombre(event.getNombre().value()));

        apply((PlatoCocinadoCocinero event) -> restaurante.cocineros.get(event.getCocineroId())
                .cocinarPlato(event.getPlato()));
    }
}
