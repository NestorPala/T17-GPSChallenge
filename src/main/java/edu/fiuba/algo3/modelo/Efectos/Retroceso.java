package edu.fiuba.algo3.modelo.Efectos;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Logger;

public class Retroceso implements IEfecto {

    public Retroceso(){

    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        Logger logger = Logger.getInstance();
        logger.log("El jugador retrocede una posición a causa de un obstáculo");
        jugador.retrocederPosicionAnterior();
    }
    
}