package edu.fiuba.algo3.model.Jugador;

public class EstadoInactivo implements IEstado {
  @Override
  public boolean puedeSeguirJugando() {
    return false;
  }
}
