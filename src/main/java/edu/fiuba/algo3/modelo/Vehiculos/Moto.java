package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;

public class Moto implements IVehiculo {

    @Override
    public int chocar(Chocable elemento) {
        return elemento.obtenerPuntosDePenalizacion(this);
    }
}
