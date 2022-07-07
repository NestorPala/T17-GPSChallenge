package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Jugador.Jugador;

public class FinDelJuego implements IEfecto {

  @Override
  public void aplicarEfecto(Jugador jugador) {
    jugador.dejarDeJugar();
  }
}
