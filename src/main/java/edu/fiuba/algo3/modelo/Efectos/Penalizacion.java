package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador;

public class Penalizacion implements IEfecto{

    private int movimientos;

    public Penalizacion(int penalizacion){
        this.movimientos = penalizacion;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.recibirPenalizacion(this.movimientos);
    }
}
