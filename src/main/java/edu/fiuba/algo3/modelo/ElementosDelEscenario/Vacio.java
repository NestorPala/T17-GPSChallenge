package edu.fiuba.algo3.modelo.ElementosDelEscenario;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Vacio implements ElementoDelEscenario{
    @Override
    public int obtenerPuntosDePenalizacion(Vehiculo vehiculo) {
        return 0;
    }
}
