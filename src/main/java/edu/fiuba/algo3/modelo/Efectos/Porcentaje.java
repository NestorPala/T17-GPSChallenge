package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador;

public class Porcentaje implements IEfecto{

    private int porcentaje;

    public Porcentaje(int porcentaje){
        this.porcentaje = porcentaje;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.recibirPorcentaje(this.porcentaje);
    }
}
