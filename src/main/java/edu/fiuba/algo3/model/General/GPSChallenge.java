package edu.fiuba.algo3.model.General;

import edu.fiuba.algo3.model.Jugador.Jugador;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
      if (!escogerSiguienteJugador()) {
        Logger.getInstance().log("Ya terminaron de jugar todos los jugadores");
      }
    }
  }

  public boolean hayJugadoresPorJugar() {
    return jugadores.size() > 0;
  }

  public boolean escogerSiguienteJugador() {
    if (hayJugadoresPorJugar()) {
      jugadorActual = jugadores.poll();
      return true;
    }
    return false;
  }

  public String[] obtenerTop10() {

    String[] top = new String[10];

    for (int i = 0; i < 10; i++) {
      top[i] = "----;----";
      if (ranking.obtenerJugadorDelTop(i) != null) {
        String nombre = ranking.obtenerJugadorDelTop(i).nombre();
        double puntaje = new BigDecimal(ranking.obtenerJugadorDelTop(i).puntaje()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        top[i] = (nombre + ";" + puntaje);
      }
    }

    return top;
  }

  public String obtenerMejorJugador() {
    return ranking.obtenerMejorJugador().nombre() + ";" + ranking.obtenerMejorJugador().puntaje();
  }

  public Jugador jugadorActual() {
    return jugadorActual;
  }
}
