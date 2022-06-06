package edu.fiuba.algo3.modelo.ElementosDelEscenario;

import edu.fiuba.algo3.modelo.Vehiculos.Moto;

public class Vacio implements ElementoDelEscenario{

    @Override
    public int obtenerPuntosDePenalizacion(Moto moto) {
        return 0;
    }
}
