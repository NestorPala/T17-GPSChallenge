package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Penalizacion;
import edu.fiuba.algo3.model.Efectos.Retroceso;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class Piquete implements Chocable {

  @Override
  public IEfecto devolverEfecto(Moto moto) {
    Logger.getInstance().log("El jugador iba con una moto y se chocó con un piquete");
    return new Penalizacion(2);
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    Logger.getInstance().log("El jugador iba con un auto y se chocó con un piquete");
    return new Retroceso();
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    Logger.getInstance().log("El jugador iba con un todoterreno y se chocó con un piquete");
    return new Retroceso();
  }
}
