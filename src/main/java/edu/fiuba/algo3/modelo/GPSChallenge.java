package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

import java.util.ArrayDeque;
import java.util.Queue;

public class GPSChallenge {
    private Queue<Jugador> jugadores;
    private Jugador jugadorActual;
    private Ranking ranking;
    private Escenario escenario;

    public GPSChallenge() {
        jugadores = new ArrayDeque<Jugador>();
        jugadorActual = null;
        ranking = new Ranking();
        escenario = Escenario.getInstance();
        System.out.println("Nueva partida de GPSChallenge");
    }

    public GPSChallenge(int alto, int ancho) {
        jugadores = new ArrayDeque<Jugador>();
        jugadorActual = null;
        ranking = new Ranking();
        escenario = Escenario.getInstance(alto, ancho);
        System.out.println("Nueva partida de GPSChallenge");
    }

    public void agregarJugador(Jugador unJugador) {
        jugadores.add(unJugador);
        if (jugadorActual == null) {
            jugadorActual = jugadores.poll();
        }
        System.out.println("Jugador agregado al juego");
    }

    /*
    public void jugar() {
        jugadorActual = jugadores.poll();
        while (hayJugadoresPorJugar()) {
            while (jugadorActual.puedeSeguirJugando()) {
                // selector comandos
            }
            ranking.agregar(jugadorActual);
            jugadorActual = jugadores.poll();
        }
    }
    */

    public void mover(Direccion unaDireccion) {
        System.out.println("Mover al jugador");
        jugadorActual.mover(unaDireccion);
        if (!jugadorActual.puedeSeguirJugando()) {
            System.out.println("El jugador llego a la meta");
            ranking.agregar(jugadorActual);
            if (hayJugadoresPorJugar()) {
                jugadorActual = jugadores.poll();
            }
        }
    }

    public boolean hayJugadoresPorJugar() {
        return jugadores.size() > 0;
    }

    public void obtenerTop10() {
        ranking.obtenerTop10();
    }

    public Jugador obtenerMejorJugador() {
        return ranking.obtenerMejorJugador();
    }
}
