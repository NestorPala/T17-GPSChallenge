package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Posicion;

public abstract class Vehiculo {
    public Posicion mover(Direccion unaDireccion, Posicion unaPosicion) {
        Posicion nuevaPosicion = unaDireccion.calcularNuevaPosicion(unaPosicion);
        return nuevaPosicion;
    }

    abstract public Efecto chocar(Chocable chocable);
}
