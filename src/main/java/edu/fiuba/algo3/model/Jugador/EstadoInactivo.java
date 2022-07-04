package edu.fiuba.algo3.model.Jugador;

public class EstadoInactivo implements IEstado {
  public EstadoInactivo() {}

  @Override
  public boolean puedeSeguirJugando() {
    return false;
  }
}
