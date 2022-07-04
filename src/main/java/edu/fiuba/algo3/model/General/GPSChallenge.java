package edu.fiuba.algo3.model.General;

import edu.fiuba.algo3.model.Jugador.Jugador;

import java.util.ArrayDeque;
import java.util.Queue;

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
    jugadorActual.mover(unaDireccion);

    if (!jugadorActual.puedeSeguirJugando()) {
      Logger.getInstance().log("El jugador " + jugadorActual.nombre() + " llego a la meta");
      ranking.agregar(jugadorActual);
      escogerSiguienteJugador();
    }
  }

  public boolean hayJugadoresPorJugar() {
    return jugadores.size() > 0;
  }

  public void escogerSiguienteJugador() {
    if (jugadores.size() > 0) {
      jugadorActual = jugadores.poll();
    }
  }

  public String[] obtenerTop10() {

    String[] top = new String[10];

    for (int i = 0; i < 10; i++) {
      top[i] = "-;-";
      if (ranking.obtenerJugadorDelTop(i) != null) {
        String nombre = ranking.obtenerJugadorDelTop(i).nombre();
        String puntaje = Double.toString(ranking.obtenerJugadorDelTop(i).puntaje());
        top[i] = (nombre + ";" + puntaje);
      }
    }

    return top;
  }

  public Jugador obtenerMejorJugador() {
    return ranking.obtenerMejorJugador();
  }

  public Jugador jugadorActual() {
    return jugadorActual;
  }
}