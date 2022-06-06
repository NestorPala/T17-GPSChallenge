package edu.fiuba.algo3.modelo.ElementosDelEscenario;

import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class Pozo implements ElementoDelEscenario{

    @Override
    public int obtenerPuntosDePenalizacion(Vehiculo vehiculo) {
        // Cambiar
        if(vehiculo instanceof Moto){
            return 3;
        }

        return 0;
    }
}
