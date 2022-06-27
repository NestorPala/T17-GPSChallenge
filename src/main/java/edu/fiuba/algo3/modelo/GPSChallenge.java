package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayDeque;
import java.util.Queue;

public class GPSChallenge {
    private Queue<Jugador> jugadores;
    private Jugador jugadorActual;
    private Ranking ranking;

    public GPSChallenge() {
        jugadores = new ArrayDeque<Jugador>();
        jugadorActual = null;
        ranking = new Ranking();
    }

    public void agregarJugador(Jugador unJugador) {
        jugadores.add(unJugador);
    }

    public void jugar() {
        while (jugadorActual.puedeSeguirJugando()) {
            // selector comandos
        }
        ranking.agregar(jugadorActual);
        jugadorActual = jugadores.poll();
    }
}
