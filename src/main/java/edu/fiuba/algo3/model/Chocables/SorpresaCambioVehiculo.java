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
    return new CambioDeVehiculo(new Auto());
  }

  @Override
  public IEfecto devolverEfecto(Auto auto) {
    return new CambioDeVehiculo(new Todoterreno());
  }

  @Override
  public IEfecto devolverEfecto(Todoterreno todoterreno) {
    return new CambioDeVehiculo(new Moto());
  }

  @Override
  public String toString() {
    return "sorpresa de cambio de vehiculo";
  }
}
