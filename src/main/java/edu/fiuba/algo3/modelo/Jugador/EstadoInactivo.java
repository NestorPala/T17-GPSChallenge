package edu.fiuba.algo3.modelo.Jugador;

public class EstadoInactivo implements IEstado {
    public EstadoInactivo() {}

    @Override
    public boolean puedeSeguirJugando() {
        return false;
    }

    @Override
    public void mover() {

    }
}