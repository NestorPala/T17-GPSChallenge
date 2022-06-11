package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Pozo implements Chocable {

    @Override
    public int obtenerPuntosDePenalizacion(Moto moto) {
        return 3;
    }

    @Override
    public int obtenerPuntosDePenalizacion(Auto auto) {
        return 3;
    }

    @Override
    public int obtenerPuntosDePenalizacion(Todoterreno todoterreno) {
        return 2;
    }
}
