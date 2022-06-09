package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocables;

public class Auto implements Vehiculo {

    @Override
    public int chocar(Chocables elemento) {
        return elemento.obtenerPuntosDePenalizacion(this);
    }
}
