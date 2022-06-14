package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public class Vacio implements Chocable {
    @Override
    public Vehiculo aplicarPenalizacion(Moto moto, Puntaje puntaje) {
        puntaje.sumarMovimientos(0);
        return moto;
    }

    @Override
    public Vehiculo aplicarPenalizacion(Auto auto, Puntaje puntaje) {
        puntaje.sumarMovimientos(0);
        return auto;
    }

    @Override
    public Vehiculo aplicarPenalizacion(Todoterreno todoterreno, Puntaje puntaje) {
        puntaje.sumarMovimientos(0);
        return todoterreno;
    }
}
