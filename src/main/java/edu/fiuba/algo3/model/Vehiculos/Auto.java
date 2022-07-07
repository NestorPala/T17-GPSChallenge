package edu.fiuba.algo3.model.Vehiculos;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Logger;

public class Auto extends Vehiculo {

  public Auto() {
    Logger.getInstance().log("El jugador tiene como vehiculo un auto");
  }

  @Override
  public IEfecto chocar(Chocable chocable) {
    return chocable.devolverEfecto(this);
  }

  @Override
  public String toString() {
    return "auto";
  }
}
