package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.Penalizacion;
import edu.fiuba.algo3.modelo.Efectos.Retroceso;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Piquete implements Chocable {

    private final Logger logger = Logger.getInstance();

    @Override
    public IEfecto devolverEfecto(Moto moto) {
        logger.log("El jugador iba con una moto y se chocó con un piquete");
        return new Penalizacion(2);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        logger.log("El jugador iba con un auto y se chocó con un piquete");
        return new Retroceso();
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        logger.log("El jugador iba con un todoterreno y se chocó con un piquete");
        return new Retroceso();
    }
}
