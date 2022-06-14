package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public class ControlPolicial implements Chocable{

    @Override
    public Vehiculo aplicarPenalizacion(Moto moto, Puntaje puntaje) {
        if(Math.random() >= 0.2) puntaje.sumarMovimientos(3);
        return moto;
    }

    @Override
    public Vehiculo aplicarPenalizacion(Auto auto, Puntaje puntaje) {
        if(Math.random() >= 0.5) puntaje.sumarMovimientos(3);
        return auto;
    }

    @Override
    public Vehiculo aplicarPenalizacion(Todoterreno todoterreno, Puntaje puntaje) {
        if(Math.random() >= 0.7) puntaje.sumarMovimientos(3);
        return todoterreno;
    }
}