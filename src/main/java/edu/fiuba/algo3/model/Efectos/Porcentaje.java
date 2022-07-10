package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Jugador.Jugador;

public class Porcentaje implements IEfecto {

  private final int porcentaje;

  public Porcentaje(int porcentaje) {
    this.porcentaje = porcentaje;
  }

  @Override
  public void aplicarEfecto(Jugador jugador) {
    jugador.recibirPorcentaje(this.porcentaje);
  }
}
