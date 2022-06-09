package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocables;

public class Moto implements Vehiculo {

    @Override
    public int chocar(Chocables elemento) {
        return elemento.obtenerPuntosDePenalizacion(this);
    }
}
