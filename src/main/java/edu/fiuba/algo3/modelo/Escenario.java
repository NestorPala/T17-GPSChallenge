package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Chocables.IChocable;
import edu.fiuba.algo3.modelo.Chocables.Vacio;

public class Escenario {
    private final int altura;
    private final int anchura;
    private final IChocable[][] matriz;

    public Escenario(int alturaInicial, int anchuraInicial) throws EscenarioConLimitesInvalidosError {
        if (alturaInicial < 0 || anchuraInicial < 0) {
            throw new EscenarioConLimitesInvalidosError();
        }

        this.altura = alturaInicial;
        this.anchura = anchuraInicial;
        this.matriz = new IChocable[anchuraInicial][alturaInicial];

        for (int i = 0; i < anchuraInicial; i++) {
            for (int j = 0; j < alturaInicial; j++) {
                matriz[i][j] = new Vacio();
            }
        }
    }

    public boolean estaDentroDelEscenario(Posicion pos) {
        int posX = pos.x();
        int posY = pos.y();

        if (posX < 0 || posX > anchura) {
            return false;
        }

        return posY >= 0 && posY <= altura;
    }

    public void insertarChocable(IChocable elemento, Posicion pos) {
        if (estaDentroDelEscenario(pos)) {
            matriz[pos.x()][pos.y()] = elemento;
        }
    }

    public IChocable obtenerChocableEnPosicion(Posicion pos) {
        if (estaDentroDelEscenario(pos)) {
            return matriz[pos.x()][pos.y()];
        }
        return null;
    }
}
