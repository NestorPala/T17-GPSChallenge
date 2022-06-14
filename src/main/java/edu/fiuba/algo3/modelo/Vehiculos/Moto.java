package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Puntaje;

public class Moto extends Vehiculo {
    @Override
    public Vehiculo chocar(Chocable chocable, Puntaje puntaje) {
        return chocable.aplicarPenalizacion(this, puntaje);
    }
}
