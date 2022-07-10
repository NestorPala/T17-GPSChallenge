package edu.fiuba.algo3.model.General;

import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Puntaje.Ranking;

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
    Logger.getInstance().log("Se creó una nueva partida");
    jugadores = new ArrayDeque<Jugador>();
    jugadorActual = null;
    ranking = new Ranking();
    escenario = Escenario.getInstance();
    escenario.generarObstaculos();
  }

  public GPSChallenge(int alto, int ancho) {
    jugadores = new ArrayDeque<Jugador>();
    jugadorActual = null;
    ranking = new Ranking();
    escenario = Escenario.getInstance(alto, ancho);
    escenario.generarObstaculos();
    Logger.getInstance().log("Se creó una nueva partida");
  }

  public void agregarJugador(Jugador unJugador) {
    jugadores.add(unJugador);
    Logger.getInstance().log("Jugador " + unJugador.nombre() + " agregado al juego");
    if (jugadorActual == null) {
      escogerSiguienteJugador();
    }
  }

  public void mover(Direccion unaDireccion) {
    jugadorActual.mover(unaDireccion);

    if (!jugadorActual.puedeSeguirJugando()) {
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
      Logger.getInstance().log("El jugador actual es: " + jugadorActual.nombre());
      return;
    }
    Logger.getInstance().log("Finalizó la partida");
  }

  public String[] obtenerTop10() {

    String[] top = new String[10];

    for (int i = 0; i < 10; i++) {
      top[i] = "----;----";
      if (ranking.obtenerJugadorDelTop(i) != null) {
        String nombre = ranking.obtenerJugadorDelTop(i).nombre();
        double puntaje = BigDecimal.valueOf(ranking.obtenerJugadorDelTop(i).puntaje()).setScale(2, RoundingMode.HALF_UP).doubleValue();
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
