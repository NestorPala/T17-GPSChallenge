package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
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
    public void puedoCambiarAlJugadorDePosicion() 
    throws PosicionDelEscenarioInvalida 
    {
        Jugador jugador = new Jugador(new Posicion(), new Moto());
        Escenario escenario = new Escenario(10, 10);

        jugador.mover(new Arriba(), escenario);

        assertEquals(jugador.posicion(), new Posicion(0, 1));
    }




    @Test
    public void CambioAlJugadorAUnaPosicionInvalidaNoHaceNada() 
    throws PosicionDelEscenarioInvalida 
    {
        Jugador jugador = new Jugador(new Posicion(), new Moto());
        Escenario escenario = new Escenario(10, 10);

        jugador.mover(new Izquierda(), escenario);

        assertEquals(jugador.posicion(), new Posicion(0, 0));
    }



}
