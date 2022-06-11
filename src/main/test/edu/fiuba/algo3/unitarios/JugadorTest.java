package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Movimiento.Abajo;
import edu.fiuba.algo3.modelo.Movimiento.Arriba;
import edu.fiuba.algo3.modelo.Movimiento.Izquierda;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {




    @Test
    public void unJugadorInicializaCorrectamente() {
        Jugador jugador = new Jugador(new Posicion(1, 1), new Moto());

        assertEquals(jugador.puntaje(), 0);
    }




    @Test
    public void puedoCambiarAlJugadorDePosicion() throws EscenarioConLimitesInvalidosError {
        Jugador jugador = new Jugador(new Posicion(), new Moto());
        Escenario escenario = new Escenario(10, 10);

        jugador.moverse(new Arriba(), escenario);

        assertEquals(jugador.posicionDelJugador(), new Posicion(0, 1));
    }




    @Test
    public void CambioAlJugadorAUnaPosicionInvalidaNoHaceNada() throws EscenarioConLimitesInvalidosError {
        Jugador jugador = new Jugador(new Posicion(), new Moto());
        Escenario escenario = new Escenario(10, 10);

        jugador.moverse(new Izquierda(), escenario);

        assertEquals(jugador.posicionDelJugador(), new Posicion(0, 0));
    }


    
}
