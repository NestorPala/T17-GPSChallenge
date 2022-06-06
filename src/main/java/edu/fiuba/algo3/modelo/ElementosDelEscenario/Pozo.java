package edu.fiuba.algo3.modelo.ElementosDelEscenario;

import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Pozo implements ElementoDelEscenario{
    
    @Override
    public int obtenerPuntosDePenalizacion(Moto moto) {
        return 3;
    }
}
