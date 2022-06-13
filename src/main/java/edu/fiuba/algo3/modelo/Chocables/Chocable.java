package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public interface Chocable {
    void obtenerPuntosDePenalizacion(Moto moto, Puntaje puntaje);

    void obtenerPuntosDePenalizacion(Auto auto, Puntaje puntaje);

    void obtenerPuntosDePenalizacion(Todoterreno todoterreno, Puntaje puntaje);
}
