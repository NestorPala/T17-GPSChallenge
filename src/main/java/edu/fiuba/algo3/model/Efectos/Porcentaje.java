package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;

public class Porcentaje implements IEfecto{

    private int porcentaje;

    public Porcentaje(int porcentaje){
        this.porcentaje = porcentaje;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        Logger logger = Logger.getInstance();
        logger.log("El jugador recibe un porcentaje del " + this.porcentaje + "% a sus puntos");
        jugador.recibirPorcentaje(this.porcentaje);
    }
}
