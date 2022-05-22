package co.com.rappi.delivery.cuenta.commands;

import co.com.rappi.delivery.cuenta.values.CuentaId;
import co.com.rappi.delivery.cuenta.values.Saldo;
import co.com.sofka.domain.generic.Command;

public final class AgregarRappiPay extends Command {
    private final CuentaId cuentaId;
    private final Saldo saldo;

    public AgregarRappiPay(CuentaId cuentaId, Saldo saldo){
        this.cuentaId = cuentaId;
        this.saldo = saldo;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Saldo getSaldo() {
        return saldo;
    }
}
