package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Chocables.IChocable;
import edu.fiuba.algo3.modelo.Chocables.Vacio;

public class Escenario {
    private final int alto;
    private final int ancho;
    private final IChocable[][] chocables;

    public Escenario(int alturaInicial, int anchuraInicial) 
    throws EscenarioConLimitesInvalidosError 
    {
        if (alturaInicial < 0 || anchuraInicial < 0) {
            throw new EscenarioConLimitesInvalidosError();
        }

        this.alto = alturaInicial;
        this.ancho = anchuraInicial;
        this.chocables = new IChocable[anchuraInicial][alturaInicial];

        for (int i = 0; i < anchuraInicial; i++) {
            for (int j = 0; j < alturaInicial; j++) {
                chocables[i][j] = new Vacio();
            }
        }
    }

    public boolean estaDentroDelEscenario(Posicion posicion) {
        int posX = posicion.x();
        int posY = posicion.y();

        if (posX < 0 || posX > ancho) {
            return false;
        }

        return posY >= 0 && posY <= alto;
    }

    public void insertarChocable(IChocable chocable, Posicion posicion) {
        if (estaDentroDelEscenario(posicion)) {
            chocables[posicion.x()][posicion.y()] = chocable;
        }
    }

    public IChocable obtenerChocable(Posicion posicion) {
        if (estaDentroDelEscenario(posicion)) {
            return chocables[posicion.x()][posicion.y()];
        }
        return null;
    }
}
