package co.com.rappi.delivery.restaurante;

import co.com.rappi.delivery.cuenta.Cuenta;
import co.com.rappi.delivery.generic.values.*;
import co.com.rappi.delivery.restaurante.events.*;
import co.com.rappi.delivery.restaurante.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Restaurante extends AggregateEvent<RestauranteId> {
    protected Map<MenuId, Menu> menus;
    protected Map<DespachadorId, Despachador> despachadores;
    protected Map<CocineroId, Cocinero> cocineros;
    protected Nombre nombre;
    protected Calificacion calificacion;
    protected Set<Categoria> categorias;
    protected Set<Ubicacion> ubicaciones;
    protected CostoEnvio costoEnvio;

    public Restaurante(RestauranteId restauranteId, Nombre nombre, CostoEnvio costoEnvio) {
        super(restauranteId);
        appendChange(new RestauranteCreado(nombre, costoEnvio)).apply();
        subscribe(new RestauranteEventChange(this));
    }

    private Restaurante(RestauranteId restauranteId){
        super(restauranteId);
        subscribe(new RestauranteEventChange(this));
    }

    public static Restaurante from(RestauranteId restauranteId, List<DomainEvent> events){
        var restaurante = new Restaurante(restauranteId);
        events.forEach(restaurante::applyEvent);
        return restaurante;
    }

    public void agregarDespachador(Nombre nombre){
        var despachadorId = new DespachadorId();
        appendChange(new DespachadorAgregado(despachadorId, nombre)).apply();
    }

    public void agregarCocinero(Nombre nombre){
        var despachadorId = new DespachadorId();
        appendChange(new DespachadorAgregado(despachadorId, nombre)).apply();
    }

    public void actualizarNombre(Nombre nombre){
        appendChange(new NombreActualizado(nombre)).apply();
    }

    public void agregarCategoria(Categoria categoria){
        appendChange(new CategoriaAgregada(categoria)).apply();
    }

    public void actualizarCalificacion(Calificacion calificacion){
        appendChange(new CalificacionActualizada(calificacion)).apply();
    }

    public void actualiazarCostoEnvio(CostoEnvio costoEnvio){
        appendChange(new CostoEnvioActualizado(costoEnvio)).apply();
    }

    public void agregarUbicacion(Ubicacion ubicacion){
        appendChange(new UbicacionAgregada(ubicacion)).apply();
    }

    public void agregarPlatoMenu(MenuId menuId, Plato plato){
        appendChange(new PlatoAgregadoMenu(menuId, plato)).apply();
    }

    public void actualizarNombreMenu(MenuId menuId, Nombre nombre){
        appendChange(new NombreMenuActualizado(menuId, nombre)).apply();
    }

    public void actualizarPrecioMenu(MenuId menuId, Precio precio){
        appendChange(new PrecioMenuActualizado(menuId, precio)).apply();
    }

    public void despacharPlatoDespachador(DespachadorId despachadorId, Plato plato){
        appendChange(new PlatoDespachadoDespachador(despachadorId, plato));
    }

    public void actualizarNombreDespachador(DespachadorId despachadorId, Nombre nombre){
        appendChange(new NombreDespachadorActualizado(despachadorId, nombre));
    }

    public void actualizarNombreCocinero(CocineroId cocineroId, Nombre nombre){
        appendChange(new NombreCocineroActualizado(cocineroId, nombre));
    }

    public void cocinarPlatoCocinero(CocineroId cocineroId, Plato plato){
        appendChange(new PlatoCocinadoCocinero(cocineroId, plato));
    }
}
