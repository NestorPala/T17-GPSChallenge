package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador;

public class EfectoPenalizacion implements Efecto{

    private int movimientos;

    public EfectoPenalizacion(int penalizacion){
        this.movimientos = penalizacion;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.recibirPenalizacion(this.movimientos);
    }
}
