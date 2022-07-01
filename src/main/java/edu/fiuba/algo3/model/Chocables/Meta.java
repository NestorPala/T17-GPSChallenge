package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Efectos.FinDelJuego;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class Meta implements Chocable {

    Logger logger = Logger.getInstance();
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        logger.log("El jugador iba con una moto y se choco con la meta");
        return new FinDelJuego();
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        logger.log("El jugador iba con una moto y se choco con la meta");
        return new FinDelJuego();
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        logger.log("El jugador iba con una moto y se choco con la meta");
        return new FinDelJuego();
    }
}
