package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;

public class Penalizacion implements IEfecto{
    private final int movimientos;

    public Penalizacion(int penalizacion){
        this.movimientos = penalizacion;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        Logger.getInstance().log("El jugador recibe una penlización de " + this.movimientos);
        jugador.recibirPenalizacion(this.movimientos);
    }
}
