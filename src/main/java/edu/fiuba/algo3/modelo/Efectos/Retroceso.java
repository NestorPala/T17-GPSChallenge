package edu.fiuba.algo3.modelo.Efectos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Retroceso implements IEfecto {

    public Retroceso(){}

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.retrocederPosicionAnterior();
    }
    
}