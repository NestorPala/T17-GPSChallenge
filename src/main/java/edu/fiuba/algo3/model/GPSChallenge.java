package edu.fiuba.algo3.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.model.Jugador.Jugador;

public class GPSChallenge {
    private final Queue<Jugador> jugadores;
    private Jugador jugadorActual;
    private final Ranking ranking;
    private final Escenario escenario;

    public GPSChallenge() {
        jugadores = new ArrayDeque<Jugador>();
        jugadorActual = null;
        ranking = new Ranking();
        escenario = Escenario.getInstance();
        escenario.generarObstaculos();
        Logger.getInstance().log("Nueva partida de GPSChallenge");
    }

    public GPSChallenge(int alto, int ancho) {
        jugadores = new ArrayDeque<Jugador>();
        jugadorActual = null;
        ranking = new Ranking();
        escenario = Escenario.getInstance(alto, ancho);
        escenario.generarObstaculos();
        Logger.getInstance().log("Nueva partida de GPSChallenge");
    }

    public void agregarJugador(Jugador unJugador) {
        jugadores.add(unJugador);
        if (jugadorActual == null) {
            jugadorActual = jugadores.poll();
        }
        Logger.getInstance().log("Jugador agregado al juego");
    }

    public void mover(Direccion unaDireccion) {
        Logger.getInstance().log("Mover al jugador");
        if (jugadorActual.puedeSeguirJugando()) {
            jugadorActual.mover(unaDireccion);
        }
        if (!jugadorActual.puedeSeguirJugando()) {
            Logger.getInstance().log("El jugador llego a la meta");
            ranking.agregar(jugadorActual);
            if (hayJugadoresPorJugar()) {
                jugadorActual = jugadores.poll();
            }
        }
    }

    public boolean hayJugadoresPorJugar() {
        return jugadores.size() > 0;
    }

    public List<Jugador> obtenerTop10() {
        List<Jugador> topJugadores = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            topJugadores.add(ranking.obtenerJugadorDelTop(i));
        }

        return topJugadores;
    }

    public Jugador obtenerMejorJugador() {
        return ranking.obtenerMejorJugador();
    }

    public Jugador jugadorActual() { return jugadorActual; }
}
