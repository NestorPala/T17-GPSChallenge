package edu.fiuba.algo3.model.Vehiculos;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;

public class Moto extends Vehiculo {

    public Moto(){
        Logger logger = Logger.getInstance();
        logger.log("El jugador tiene como vehiculo una moto");
    }
    @Override
    public IEfecto chocar(Chocable chocable) {
        return chocable.devolverEfecto(this);
    }
}
