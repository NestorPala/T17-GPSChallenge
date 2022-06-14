package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public interface Chocable {
    Vehiculo aplicarPenalizacion(Moto moto, Puntaje puntaje);

    Vehiculo aplicarPenalizacion(Auto auto, Puntaje puntaje);

    Vehiculo aplicarPenalizacion(Todoterreno todoterreno, Puntaje puntaje);
}
