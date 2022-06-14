package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public class SorpresaCambioVehiculo implements Chocable {
    @Override
    public Vehiculo aplicarPenalizacion(Moto moto, Puntaje puntaje) {
        return new Auto();
    }

    @Override
    public Vehiculo aplicarPenalizacion(Auto auto, Puntaje puntaje) {
        return new Todoterreno();
    }

    @Override
    public Vehiculo aplicarPenalizacion(Todoterreno todoterreno, Puntaje puntaje) {
        return new Moto();
    }
}
