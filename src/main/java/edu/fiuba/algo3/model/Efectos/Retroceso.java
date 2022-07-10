package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Jugador.Jugador;

public class Retroceso implements IEfecto {

  public Retroceso() {}

  @Override
  public void aplicarEfecto(Jugador jugador) {
    jugador.retrocederPosicionAnterior();
  }
}
