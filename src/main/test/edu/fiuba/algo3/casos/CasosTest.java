package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosTest {

    @Test
    public void motoChocaPozoYEsPenalizadaConTresMovimientos() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        Pozo pozo = new Pozo();

        // Pongo el pozo
        escenario.ponerUnElemento(pozo, new Posicion(2, 1));

        // Muevo al jugador a la nueva posicion
        jugador.moverse(new Movimiento(1, 0), escenario);

        // Chequeo que el jugador obtenga el puntaje correcto
        assertEquals(jugador.puntajeTotal(), 4);
    }

    @Test
    public void autoChocaPozoYEsPenalizadoConTresMovimientos() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(20, 20);
        Auto auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(1, 1), auto);
        Pozo pozo = new Pozo();

        // Pongo el pozo
        escenario.ponerUnElemento(pozo, new Posicion(2, 1));

        // Muevo al jugador a la nueva posicion
        jugador.moverse(new Movimiento(1, 0), escenario);

        // Chequeo que el jugador obtenga el puntaje correcto
        assertEquals(jugador.puntajeTotal(), 4);
    }

    @Test
    public void todoterrenoChocaPozoYNoEsPenalizado() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(20, 20);
        Todoterreno todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(new Posicion(1, 1), todoterreno);
        Pozo pozo = new Pozo();

        // Pongo el pozo
        escenario.ponerUnElemento(pozo, new Posicion(2, 1));

        // Muevo al jugador a la nueva posicion
        jugador.moverse(new Movimiento(1, 0), escenario);

        // Chequeo que el jugador obtenga el puntaje correcto
        assertEquals(jugador.puntajeTotal(), 1);
    }

    @Test
    public void motoChocaConPiqueteYEsPenalizadoConDosMovimientos() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        Piquete piquete = new Piquete();

        // Pongo el pozo
        escenario.ponerUnElemento(piquete, new Posicion(2, 1));

        // Muevo al jugador a la nueva posicion
        jugador.moverse(new Movimiento(1, 0), escenario);

        // Chequeo que el jugador obtenga el puntaje correcto
        assertEquals(jugador.puntajeTotal(), 3);
    }

    @Test
    public void todoterrenoChocaConTresPozosYEsPenalizadoConDosMovimientos() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(20, 20);
        Todoterreno todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(new Posicion(1, 1), todoterreno);
        Pozo pozo = new Pozo();

        // Pongo los pozos
        escenario.ponerUnElemento(pozo, new Posicion(2, 1));
        escenario.ponerUnElemento(pozo, new Posicion(3, 1));
        escenario.ponerUnElemento(pozo, new Posicion(4, 1));

        //Muevo tres veces al jugador
        jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Movimiento(1, 0), escenario);

        // Chequeo que el jugador obtenga el puntaje correcto
        assertEquals(jugador.puntajeTotal(), 5);
    }
}
