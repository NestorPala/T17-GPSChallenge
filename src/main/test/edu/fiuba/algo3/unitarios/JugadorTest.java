package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

    @Test
    public void unJugadorInicializaCorrectamente(){
        Jugador jugador = new Jugador(new Posicion(1,1), new Moto());

        assertEquals(jugador.posicionDelJugador(), new Posicion(1,1));
        assertEquals(jugador.totalPenalizaciones(), 0);
        assertEquals(jugador.movimientosRealizados(),0);
    }

    @Test
    public void puedoCambiarAlJugadorDePosicion() throws EscenarioConLimitesInvalidosError {
        Jugador jugador = new Jugador(new Posicion(),new Moto());
        Escenario escenario = new Escenario(10,10);

        assertEquals(jugador.posicionDelJugador(), new Posicion(0,0));

        Movimiento movimiento = new Movimiento(1,1);

        jugador.moverse(movimiento,escenario);

        assertEquals(jugador.posicionDelJugador(), new Posicion(1,1));

        jugador.moverse(new Movimiento(5,2), escenario);
        assertEquals(jugador.posicionDelJugador(), new Posicion(6,3));
    }

    @Test
    public void CambioAlJugadorAUnaPosicionInvalidaNoHaceNada() throws EscenarioConLimitesInvalidosError {
        Jugador jugador = new Jugador(new Posicion(),new Moto());
        Escenario escenario = new Escenario(10,10);

        Movimiento movimiento = new Movimiento(11,11);
        jugador.moverse(movimiento, escenario);

        assertEquals(jugador.posicionDelJugador(), new Posicion(0,0));
    }
}
