package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.CambioDeVehiculo;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class SorpresaCambioVehiculo implements Chocable {
  @Override
  public IEfecto devolverEfecto(Moto moto) {
    Logger.getInstance()
        .log("El jugador iba con una moto y se choco con una sorpresa de cambio de vehiculo");
    return new CambioDeVehiculo(new Auto());
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    Logger.getInstance()
        .log("El jugador iba con un auto y se choco con una sorpresa de cambio de vehiculo");
    return new CambioDeVehiculo(new Todoterreno());
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    Logger.getInstance()
        .log("El jugador iba con una 4x4 y se choco con una sorpresa de cambio de vehiculo");
    return new CambioDeVehiculo(new Moto());
  }
}
