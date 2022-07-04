package edu.fiuba.algo3.model.Jugador;

public class EstadoActivo implements IEstado {
  public EstadoActivo() {}

  @Override
  public boolean puedeSeguirJugando() {
    return true;
  }
}
