package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Puntaje;

public abstract class Vehiculo {
    public Posicion mover(Direccion unaDireccion, Posicion unaPosicion) {
        return unaDireccion.calcularNuevaPosicion(unaPosicion);
    }

    abstract public Vehiculo chocar(Chocable chocable, Puntaje puntaje);

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
