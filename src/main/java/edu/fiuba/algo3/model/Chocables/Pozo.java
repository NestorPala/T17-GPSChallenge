package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Penalizacion;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class Pozo implements Chocable {

  @Override
  public IEfecto devolverEfecto(Moto moto) {
    return new Penalizacion(3);
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    return new Penalizacion(3);
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    todoterreno.sumarPozo();
    if (todoterreno.obtenerPozos() >= 3) {
      todoterreno.reiniciarPozos();
      return new Penalizacion(2);
    }
    return new Penalizacion(0);
  }

  @Override
  public String toString() {
    return "pozo";
  }
}
