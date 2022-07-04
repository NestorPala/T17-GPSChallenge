package edu.fiuba.algo3.unit.general;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Direccion;
import edu.fiuba.algo3.model.Escenario;
import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;

import static org.junit.jupiter.api.Assertions.*;

public class GPSChallengeTest {
    @Test
    public void test01_sePuedeJugarCorrectamente(){
        GPSChallenge juego = new GPSChallenge(20,20);
        Jugador pablo = new Jugador(new Moto(),"Pablo");

        assertFalse(juego.hayJugadoresPorJugar());

        juego.agregarJugador(pablo);
        assertEquals(juego.jugadorActual(),pablo);

        juego.mover(Direccion.derecha());
        assertFalse(juego.hayJugadoresPorJugar());
    }

    @Test
    public void test02_sePuedenTenerVariosJugadores(){
        Escenario escenario = Escenario.getInstance().reset();
        GPSChallenge juego = new GPSChallenge(10,10);
        Jugador luke = new Jugador(new Auto(), "luke");
        Jugador mariano = new Jugador(new Auto(), "mariano");

        juego.agregarJugador(luke);
        assertFalse(juego.hayJugadoresPorJugar());

        juego.agregarJugador(mariano);
        assertTrue(juego.hayJugadoresPorJugar());

        assertEquals(juego.jugadorActual(), luke);
        juego.escogerSiguienteJugador();
        assertEquals(juego.jugadorActual(), mariano);
    }
}
