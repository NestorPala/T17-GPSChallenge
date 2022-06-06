package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.ElementosDelEscenario.ElementoDelEscenario;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Moto implements Vehiculo {

    @Override
    public int chocar(ElementoDelEscenario elemento) {
        return elemento.obtenerPuntosDePenalizacion(this);
    }
}
