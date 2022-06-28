package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Logger;

public class Penalizacion implements IEfecto{
    private final int movimientos;

    public Penalizacion(int penalizacion){
        this.movimientos = penalizacion;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        Logger logger = Logger.getInstance();
        logger.log("El jugador recibe una penlizacion de " + this.movimientos);
        jugador.recibirPenalizacion(this.movimientos);
    }
}
