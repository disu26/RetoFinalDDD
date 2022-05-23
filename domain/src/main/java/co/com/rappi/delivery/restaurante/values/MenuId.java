package co.com.rappi.delivery.restaurante.values;

import co.com.sofka.domain.generic.Identity;

public final class MenuId extends Identity {
    public MenuId(String id){
        super(id);
    }

    public MenuId(){}

    public static MenuId of(String id){
        return new MenuId(id);
    }
}
