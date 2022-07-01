package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Porcentaje;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class SorpresaFavorable implements Chocable {

    private final Logger logger = Logger.getInstance();

    @Override
    public IEfecto devolverEfecto(Moto moto) {
        logger.log("El jugador iba con una moto y se choco con una sorpresa favorable");
        return new Porcentaje(-20);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        logger.log("El jugador iba con un auto y se choco con una sorpresa favorable");
        return new Porcentaje(-20);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        logger.log("El jugador iba con una 4x4 y se choco con una sorpresa favorable");
        return new Porcentaje(-20);
    }
}