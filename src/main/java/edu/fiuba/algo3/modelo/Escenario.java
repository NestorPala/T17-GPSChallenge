package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Vacio;

public class Escenario {
    private final int alto;
    private final int ancho;
    private final Chocable[][] chocables;

    private static Escenario instance;

    private Escenario()
    throws TamañoDelEscenarioInvalido
    {
        // Ahora los inicializo en 20, pero luego se pondra un valor ramdon para el juego final.
        this.alto = 20;
        this.ancho = 20;
        this.chocables = new Chocable[this.ancho][this.alto];

        for (int i = 0; i < this.ancho; i++) {
            for (int j = 0; j < this.alto; j++) {
                chocables[i][j] = new Vacio();
            }
        }
    }

    public static Escenario getInstance()
    throws TamañoDelEscenarioInvalido
    {
        if (instance == null) {
            instance = new Escenario();
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
