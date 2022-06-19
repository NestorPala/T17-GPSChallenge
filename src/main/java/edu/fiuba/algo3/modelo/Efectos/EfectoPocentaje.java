package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador;

public class EfectoPocentaje implements Efecto{

    private int porcentaje;

    public EfectoPocentaje(int porcentaje){
        this.porcentaje = porcentaje;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.recibirPorcentaje(this.porcentaje);
    }
}
