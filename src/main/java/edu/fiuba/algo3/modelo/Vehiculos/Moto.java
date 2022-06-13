package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Puntaje;

public class Moto extends Vehiculo {
    @Override
    public void chocar(Chocable chocable, Puntaje puntaje) {
        chocable.obtenerPuntosDePenalizacion(this, puntaje);
    }
}
