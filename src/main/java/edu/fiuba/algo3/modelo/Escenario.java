package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ElementosDelEscenario.ElementoDelEscenario;
import edu.fiuba.algo3.modelo.ElementosDelEscenario.Vacio;

public class Escenario {
    private int altura;
    private int anchura;
    private ElementoDelEscenario matriz[][];

    public Escenario(int alturaInicial, int anchuraInicial){
        this.altura = alturaInicial;
        this.anchura = anchuraInicial;
        this.matriz = new ElementoDelEscenario[anchuraInicial][alturaInicial];

        for(int i = 0; i < alturaInicial; i++){
            for(int j = 0; j < anchuraInicial; j++){
                matriz[i][j] = new Vacio();
            }
        }
    }

    public void ponerUnElemento(ElementoDelEscenario elemento, Posicion posicion){
        matriz[posicion.obtenerX()][posicion.obtenerY()] = elemento;
    }

    public ElementoDelEscenario obtenerElementoEnEscenario(Posicion posicion){
        return matriz[posicion.obtenerX()][posicion.obtenerY()];
    }
}
