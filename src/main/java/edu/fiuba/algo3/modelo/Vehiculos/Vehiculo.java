package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Posicion;

public abstract class Vehiculo {
    public Posicion mover(Direccion unaDireccion, Posicion unaPosicion) {
        return unaDireccion.calcularNuevaPosicion(unaPosicion);
    }

    public abstract IEfecto chocar(Chocable chocable);
}
