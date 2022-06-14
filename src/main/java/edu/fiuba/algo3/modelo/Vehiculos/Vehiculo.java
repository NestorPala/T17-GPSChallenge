package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Puntaje;

public abstract class Vehiculo {
    public Posicion mover(Direccion unaDireccion, Posicion unaPosicion) {
        Posicion nuevaPosicion = unaDireccion.calcularNuevaPosicion(unaPosicion);
        return nuevaPosicion;
    }

    abstract public void chocar(Chocable chocable, Puntaje puntaje);
}
