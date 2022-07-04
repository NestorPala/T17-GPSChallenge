package edu.fiuba.algo3.model.Jugador;

public class EstadoActivo implements IEstado {
  @Override
  public boolean puedeSeguirJugando() {
    return true;
  }
}
