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

        piquete.devolverEfecto(new Auto());
        assertEquals(puntaje.verMovimientos(), 0);

        piquete.devolverEfecto(new Moto());
        assertEquals(puntaje.verMovimientos(),2);

        piquete.devolverEfecto(new Todoterreno());
        assertEquals(puntaje.verMovimientos(), 2);
    }
}
