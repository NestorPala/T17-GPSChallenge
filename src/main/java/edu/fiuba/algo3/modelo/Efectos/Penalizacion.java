package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Logger;

public class Penalizacion implements IEfecto{
    private int movimientos;

    public Penalizacion(int penalizacion){
        Logger logger = Logger.getInstance();
        logger.log("El jugador recibe una penalización de " + penalizacion);
        this.movimientos = penalizacion;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.recibirPenalizacion(this.movimientos);
    }
}
