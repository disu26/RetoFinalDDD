package co.com.rappi.delivery.cuenta;

import co.com.rappi.delivery.cuenta.values.Movimiento;
import co.com.rappi.delivery.cuenta.values.RappiPayId;
import co.com.rappi.delivery.cuenta.values.Saldo;
import co.com.sofka.domain.generic.Entity;

import java.util.Set;

public class RappiPay extends Entity<RappiPayId> {
    protected Saldo saldo;
    protected Set<Movimiento> movimientos;

    public RappiPay(RappiPayId rappiPayId, Saldo saldo) {
        super(rappiPayId);
        this.saldo = saldo;
    }

    public void actualizarSaldo(Double value){
        this.saldo = saldo.actualizar(value);
    }

    public void agregarMovimiento(Movimiento movimiento){
        this.movimientos.add(movimiento);
    }
}
