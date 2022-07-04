package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public interface Chocable {
  IEfecto devolverEfecto(Moto moto);

  IEfecto devolverEfecto(Auto auto);

  IEfecto devolverEfecto(Todoterreno todoterreno);
}
