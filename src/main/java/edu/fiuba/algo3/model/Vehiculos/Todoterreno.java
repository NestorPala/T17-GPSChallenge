package edu.fiuba.algo3.model.Vehiculos;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Logger;

public class Todoterreno extends Vehiculo {
  private int pozosEncontrados;

  public Todoterreno() {
    this.pozosEncontrados = 0;
  }

  public void sumarPozo() {
    this.pozosEncontrados += 1;
  }

  public int obtenerPozos() {
    return this.pozosEncontrados;
  }

  public void reiniciarPozos() {
    this.pozosEncontrados = 0;
  }

  @Override
  public IEfecto chocar(Chocable chocable) {
    return chocable.devolverEfecto(this);
  }

  @Override
  public String toString() {
    return "todoterreno";
  }
}
