package edu.fiuba.algo3.modelo.Jugador;

public class EstadoActivo implements IEstado {
    public EstadoActivo() {}

    @Override
    public boolean puedeSeguirJugando() {
        return true;
    }

    @Override
    public void mover() {

    }
}
