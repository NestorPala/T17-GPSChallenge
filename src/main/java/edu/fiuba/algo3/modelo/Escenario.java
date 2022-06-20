package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Vacio;

public class Escenario {
    private final int alto;
    private final int ancho;
    private final Chocable[][] chocables;

    private static Escenario instance;

    private Escenario(int limiteAlto, int limiteAncho)
    {

        this.alto = limiteAlto;
        this.ancho = limiteAncho;
        this.chocables = new Chocable[this.ancho][this.alto];

        for (int i = 0; i < this.ancho; i++) {
            for (int j = 0; j < this.alto; j++) {
                chocables[i][j] = new Vacio();
            }
        }
    }

    public static Escenario getInstance()
    {
        if (instance == null) {
            instance = new Escenario(10,10);
        }
        return instance;
    }

    public static Escenario getInstance(int alto,int ancho) throws TamañoDelEscenarioInvalido{
        if(alto < 0 || ancho < 0){
            throw new TamañoDelEscenarioInvalido();
        }

        if(instance == null){
            instance = new Escenario(alto,ancho);
        }

        return instance;
    }

    public boolean contienePosicion(Posicion posicion) {
        int posX = posicion.x();
        int posY = posicion.y();

        if (posX < 0 || posX > ancho) {
            return false;
        }
        return posY >= 0 && posY <= alto;
    }

    public void insertarChocable(Chocable chocable, Posicion posicion) {
        if (contienePosicion(posicion)) {
            chocables[posicion.x()][posicion.y()] = chocable;
        }
    }

    public Chocable obtenerChocable(Posicion posicion) {
        if (contienePosicion(posicion)) {
            return chocables[posicion.x()][posicion.y()];
        }
        return null;
    }
}
