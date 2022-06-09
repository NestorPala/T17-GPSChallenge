package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public interface Chocables {
    int obtenerPuntosDePenalizacion(Moto moto);

    int obtenerPuntosDePenalizacion(Auto auto);

    int obtenerPuntosDePenalizacion(Todoterreno todoterreno);
}
