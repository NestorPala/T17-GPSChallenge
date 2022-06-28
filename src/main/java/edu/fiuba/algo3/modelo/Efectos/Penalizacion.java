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
        jugador.recibirPenalizacion(this.movimientos);
    }
}
