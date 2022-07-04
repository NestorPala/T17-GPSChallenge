package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class CambioDeVehiculo implements IEfecto {

  private final Vehiculo vehiculo;

  public CambioDeVehiculo(Vehiculo nuevoVehiculo) {
    this.vehiculo = nuevoVehiculo;
  }

  @Override
  public void aplicarEfecto(Jugador jugador) {
    jugador.cambiarVehiculo(this.vehiculo);
  }
}
