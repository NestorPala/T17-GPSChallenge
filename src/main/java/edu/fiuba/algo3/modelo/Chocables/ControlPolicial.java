package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public class ControlPolicial implements Chocable{

    @Override
    public void obtenerPuntosDePenalizacion(Moto moto, Puntaje puntaje) {
        if(Math.random() >= 0.2) puntaje.sumarMovimientos(3);
    }

    @Override
    public void obtenerPuntosDePenalizacion(Auto auto, Puntaje puntaje) {
        if(Math.random() >= 0.5) puntaje.sumarMovimientos(3);
    }

    @Override
    public void obtenerPuntosDePenalizacion(Todoterreno todoterreno, Puntaje puntaje) {
        if(Math.random() >= 0.7) puntaje.sumarMovimientos(3);
    }
}
