package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;

public class Porcentaje implements IEfecto {

  private final int porcentaje;

  public Porcentaje(int porcentaje) {
    this.porcentaje = porcentaje;
  }

  @Override
  public void aplicarEfecto(Jugador jugador) {
    Logger.getInstance()
        .log("El jugador recibe un porcentaje del " + this.porcentaje + "% a sus puntos");
    jugador.recibirPorcentaje(this.porcentaje);
  }
}
