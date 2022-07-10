package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Porcentaje;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class SorpresaDesfavorable implements Chocable {

  @Override
  public IEfecto devolverEfecto(Moto moto) {
    return new Porcentaje(25);
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    return new Porcentaje(25);
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    return new Porcentaje(25);
  }

  @Override
  public String toString() {
    return "sorpresa desfavorable";
  }
}
