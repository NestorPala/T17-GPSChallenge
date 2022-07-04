package edu.fiuba.algo3.model;

import java.util.ArrayDeque;
import java.util.Queue;
import org.json.JSONObject;

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
        Logger.getInstance().log("Jugador " + unJugador.nombre() + " agregado al juego");
    }

    public void mover(Direccion unaDireccion) {
        Logger.getInstance().log("Mover al jugador " + jugadorActual.nombre());
        if (jugadorActual.puedeSeguirJugando()) {
            jugadorActual.mover(unaDireccion);
        }
        if (!jugadorActual.puedeSeguirJugando()) {
            Logger.getInstance().log("El jugador " + jugadorActual.nombre() + " llego a la meta");
            ranking.agregar(jugadorActual);
            if (hayJugadoresPorJugar()) {
                jugadorActual = jugadores.poll();
            }
        }
    }

    public boolean hayJugadoresPorJugar() {
        return jugadores.size() > 0;
    }

    public JSONObject obtenerTop10() {
        JSONObject obj = new JSONObject();

        for(int i = 0; i < 10; i++){
            if(ranking.obtenerJugadorDelTop(i) != null){
                obj.put(ranking.obtenerJugadorDelTop(i).nombre(),ranking.obtenerJugadorDelTop(i).puntaje());
            }
        }

        return obj;
    }

    public Jugador obtenerMejorJugador() {
        return ranking.obtenerMejorJugador();
    }

    public Jugador jugadorActual() { return jugadorActual; }
}
