package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.GPSChallenge;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GPSChallengeTest {
    @Test
    public void sePuedeJugarCorrectamente(){
        GPSChallenge juego = new GPSChallenge(20,20);
        Jugador pablo = new Jugador(new Moto(),"Pablo");

        juego.agregarJugador(pablo);
        assertEquals(juego.jugadorActual(),pablo);

        juego.mover(Direccion.derecha());
        assertFalse(juego.hayJugadoresPorJugar());
    }

    @Test
    public void puedoTerminarElJuego(){
        Escenario escenario = Escenario.getInstance();
        escenario = escenario.reset();

        GPSChallenge juego = new GPSChallenge(10,10);
        Jugador luke = new Jugador(new Auto(), "luke");

        
    }
}
