package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.Porcentaje;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class SorpresaDesfavorable implements Chocable {

    private final Logger logger = Logger.getInstance();
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        logger.log("El jugador iba con una moto y se choco con una sorpresa desfavorable");
        return new Porcentaje(25);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        logger.log("El jugador iba con un auto y se choco con una sorpresa desfavorable");
        return new Porcentaje(25);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        logger.log("El jugador iba con una 4x4 y se choco con una sorpresa desfavorable");
        return new Porcentaje(25);
    }
}
