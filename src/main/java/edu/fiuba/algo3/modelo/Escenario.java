package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Vacio;

public class Escenario {
    private final int alto;
    private final int ancho;
    private final Chocable[][] chocables;

    private static Escenario instance;

    private Escenario(int alturaInicial, int anchuraInicial) 
    throws TamañoDelEscenarioInvalido
    {
        if (alturaInicial < 0 || anchuraInicial < 0) {
            throw new TamañoDelEscenarioInvalido();
        }
        this.alto = alturaInicial;
        this.ancho = anchuraInicial;
        this.chocables = new Chocable[anchuraInicial][alturaInicial];

        for (int i = 0; i < anchuraInicial; i++) {
            for (int j = 0; j < alturaInicial; j++) {
                chocables[i][j] = new Vacio();
            }
        }
    }

    public static Escenario getInstance(int alturaInicial, int anchuraInicial) 
    throws TamañoDelEscenarioInvalido
    {
        if (instance == null) {
            instance = new Escenario(alturaInicial, anchuraInicial);
        }
        return instance;
    }

    public boolean estaDentroDelEscenario(Posicion posicion) {
        int posX = posicion.x();
        int posY = posicion.y();

        if (posX < 0 || posX > ancho) {
            return false;
        }
        return posY >= 0 && posY <= alto;
    }

    public void insertarChocable(Chocable chocable, Posicion posicion) {
        if (estaDentroDelEscenario(posicion)) {
            chocables[posicion.x()][posicion.y()] = chocable;
        }
    }

    public Chocable obtenerChocable(Posicion posicion) {
        if (estaDentroDelEscenario(posicion)) {
            return chocables[posicion.x()][posicion.y()];
        }
        return null;
    }
}
