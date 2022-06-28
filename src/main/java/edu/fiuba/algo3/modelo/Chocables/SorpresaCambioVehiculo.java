package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class SorpresaCambioVehiculo implements Chocable {

    private final Logger logger = Logger.getInstance();

    @Override
    public IEfecto devolverEfecto(Moto moto) {
        logger.log("El jugador iba con una moto y se choco con una sorpresa de cambio de vehiculo");
        return new CambioDeVehiculo(new Auto());
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        logger.log("El jugador iba con un auto y se choco con una sorpresa de cambio de vehiculo");
        return new CambioDeVehiculo(new Todoterreno());
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        logger.log("El jugador iba con una 4x4 y se choco con una sorpresa de cambio de vehiculo");
        return new CambioDeVehiculo(new Moto());
    }
}
