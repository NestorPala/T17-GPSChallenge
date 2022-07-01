package edu.fiuba.algo3.model.Efectos;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;

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