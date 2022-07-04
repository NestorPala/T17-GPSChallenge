package edu.fiuba.algo3.unit.chocables;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Pozo;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PozoTest {

    @Test
    public void test01_puedoObtenerLosPuntosDePenalizacionCorrectosPorCadaVehiculo(){
        Chocable pozo = new Pozo();
        Jugador jugador1 = new Jugador(new Auto(), "Juan");

        IEfecto efecto = pozo.devolverEfecto(new Auto());
        efecto.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 3);

        IEfecto efecto2 = pozo.devolverEfecto(new Moto());
        efecto2.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 6);

        IEfecto efecto3 = pozo.devolverEfecto(new Todoterreno());
        efecto3.aplicarEfecto(jugador1);
        assertEquals(jugador1.puntaje(), 6);
    }
    
}
