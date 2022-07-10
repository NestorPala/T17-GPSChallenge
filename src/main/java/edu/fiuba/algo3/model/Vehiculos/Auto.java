package edu.fiuba.algo3.model.Vehiculos;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Logger;

public class Auto extends Vehiculo {
  @Override
  public IEfecto chocar(Chocable chocable) {
    return chocable.devolverEfecto(this);
  }

  @Override
  public String toString() {
    return "auto";
  }
}
