package edu.fiuba.algo3.unit;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Piquete;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PiqueteTest {

    @Test
    public void puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable piquete = new Piquete();
        Vehiculo vehiculo1 = new Auto();
        Jugador jugador1 = new Jugador(vehiculo1, "Juan");

        IEfecto efecto1 = piquete.devolverEfecto(new Auto());
        efecto1.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 0);

        IEfecto efecto2 = piquete.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(),2);

        IEfecto efecto3 = piquete.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 2);
    }
    
}
