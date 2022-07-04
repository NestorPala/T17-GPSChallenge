package edu.fiuba.algo3.model.Vehiculos;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;

public class Auto extends Vehiculo {

    public Auto(){
        Logger.getInstance().log("El jugador tiene como vehiculo un auto");
    }
    @Override
    public IEfecto chocar(Chocable chocable) {
        return chocable.devolverEfecto(this);
    }
}
