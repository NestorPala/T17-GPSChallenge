package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.IChocable;

public class Moto implements IVehiculo {

    @Override
    public int chocar(IChocable elemento) {
        return elemento.obtenerPuntosDePenalizacion(this);
    }
}
