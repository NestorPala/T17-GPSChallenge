package edu.fiuba.algo3.model.Puntaje;

import edu.fiuba.algo3.model.Jugador.Jugador;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Ranking {
  private final List<Jugador> jugadores;

  public Ranking() {
    jugadores = new LinkedList<Jugador>();
  }

  public void agregar(Jugador unJugador) {
    if (!jugadores.contains(unJugador)) {
      jugadores.add(unJugador);
      jugadores.sort(Comparator.comparing(Jugador::puntaje));
    }
  }

  public Jugador obtenerJugadorDelTop(int posicionDelTop) {
    if (jugadores.isEmpty() || posicionDelTop >= jugadores.size()) {
      return null;
    }

    return jugadores.get(posicionDelTop);
  }

  public Jugador obtenerMejorJugador() {
    if (jugadores.isEmpty()) {
      return null;
    }
    return jugadores.get(0);
  }
}
