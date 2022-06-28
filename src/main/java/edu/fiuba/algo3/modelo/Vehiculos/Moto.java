package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Logger;

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
