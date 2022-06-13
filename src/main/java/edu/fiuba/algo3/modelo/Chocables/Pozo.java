package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public class Pozo implements Chocable {
    @Override
    public void obtenerPuntosDePenalizacion(Moto moto, Puntaje puntaje) {
        puntaje.sumarMovimientos(3);
    }

    @Override
    public void obtenerPuntosDePenalizacion(Auto auto, Puntaje puntaje) {
        puntaje.sumarMovimientos(3);
    }

    @Override
    public void obtenerPuntosDePenalizacion(Todoterreno todoterreno, Puntaje puntaje) {
        puntaje.sumarMovimientos(2);
    }
}
