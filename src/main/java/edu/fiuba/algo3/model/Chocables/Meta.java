package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.FinDelJuego;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class Meta implements Chocable {

  @Override
  public IEfecto devolverEfecto(Moto moto) {
    return new FinDelJuego();
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    return new FinDelJuego();
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    return new FinDelJuego();
  }

  @Override
  public String toString() {
    return "meta";
  }
}
