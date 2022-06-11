package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Piquete implements IChocable {
    @Override
    public int obtenerPuntosDePenalizacion(Moto moto) {
        return 2;
    }

    @Override
    public int obtenerPuntosDePenalizacion(Auto auto) {
        return 0;
    }

    @Override
    public int obtenerPuntosDePenalizacion(Todoterreno todoterreno) {
        return 0;
    }
}
