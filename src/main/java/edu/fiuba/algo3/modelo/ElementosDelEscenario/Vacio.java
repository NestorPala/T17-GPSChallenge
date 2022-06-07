package edu.fiuba.algo3.modelo.ElementosDelEscenario;

import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Vacio implements ElementoDelEscenario {

    @Override
    public int obtenerPuntosDePenalizacion(Moto moto) {
        return 0;
    }

    @Override
    public int obtenerPuntosDePenalizacion(Auto auto) {
        return 0;
    }

    @Override
    public int obtenerPuntosDePenalizacion(Todoterreno todoterreno) {
        return 0;
    }
}
