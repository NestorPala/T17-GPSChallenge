package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {
    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable piquete = new Piquete();
        Puntaje puntaje = new Puntaje();

        piquete.aplicarPenalizacion(new Auto(), puntaje);
        assertEquals(puntaje.verMovimientos(), 0);

        piquete.aplicarPenalizacion(new Moto(), puntaje);
        assertEquals(puntaje.verMovimientos(),2);

        piquete.aplicarPenalizacion(new Todoterreno(), puntaje);
        assertEquals(puntaje.verMovimientos(), 2);
    }
}
