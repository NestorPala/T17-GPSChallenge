package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.ElementosDelEscenario.ElementoDelEscenario;

public class Auto implements Vehiculo {

    @Override
    public int chocar(ElementoDelEscenario elemento) {
        return elemento.obtenerPuntosDePenalizacion(this);
    }
}
