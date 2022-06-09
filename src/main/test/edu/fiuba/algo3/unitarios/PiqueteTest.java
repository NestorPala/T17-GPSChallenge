package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {
    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Piquete piquete = new Piquete();

        assertEquals(piquete.obtenerPuntosDePenalizacion(new Auto()), 0);
        assertEquals(piquete.obtenerPuntosDePenalizacion(new Todoterreno()), 0);
        assertEquals(piquete.obtenerPuntosDePenalizacion(new Moto()), 2);
    }
}
