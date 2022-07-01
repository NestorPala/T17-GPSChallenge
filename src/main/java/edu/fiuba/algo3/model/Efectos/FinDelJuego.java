package edu.fiuba.algo3.model.Efectos;

import edu.fiuba.algo3.model.Jugador.Jugador;

public class FinDelJuego implements IEfecto {

    public FinDelJuego(){}

    @Override
    public void aplicarEfecto(Jugador jugador) {
        // Efecto que le impida volver a jugar al Jugador
        jugador.dejarDeJugar();
    }
}
