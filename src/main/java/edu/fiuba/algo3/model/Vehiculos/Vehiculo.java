package edu.fiuba.algo3.model.Vehiculos;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Direccion;
import edu.fiuba.algo3.model.General.Posicion;

public abstract class Vehiculo {
  public Posicion mover(Direccion unaDireccion, Posicion unaPosicion) {
    return unaDireccion.calcularNuevaPosicion(unaPosicion);
  }

  public abstract IEfecto chocar(Chocable chocable);
}
