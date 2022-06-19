package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Posicion;

public abstract class Vehiculo {
    public Posicion mover(Direccion unaDireccion, Posicion unaPosicion) {
        Posicion nuevaPosicion = unaDireccion.calcularNuevaPosicion(unaPosicion);
        return nuevaPosicion;
    }

    public abstract IEfecto chocar(Chocable chocable);
}
