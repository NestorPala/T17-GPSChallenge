package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {

    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable pozo = new Pozo();
        Puntaje puntaje = new Puntaje();

        pozo.aplicarPenalizacion(new Auto(), puntaje);
        assertEquals(puntaje.verMovimientos(), 3);

        pozo.aplicarPenalizacion(new Moto(), puntaje);
        assertEquals(puntaje.verMovimientos(),6);

        pozo.aplicarPenalizacion(new Todoterreno(), puntaje);
        assertEquals(puntaje.verMovimientos(), 6);
    }
}
