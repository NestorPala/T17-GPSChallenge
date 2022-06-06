package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.ElementosDelEscenario.ElementoDelEscenario;
import edu.fiuba.algo3.modelo.ElementosDelEscenario.Vacio;

public class Escenario {
    private int altura;
    private int anchura;
    private ElementoDelEscenario[][] matriz;

    public Escenario(int alturaInicial, int anchuraInicial) throws EscenarioConLimitesInvalidosError {
        if(alturaInicial < 0 || anchuraInicial < 0){
            throw new EscenarioConLimitesInvalidosError();
        }

        this.altura = alturaInicial;
        this.anchura = anchuraInicial;
        this.matriz = new ElementoDelEscenario[anchuraInicial][alturaInicial];

        for(int i = 0; i < anchuraInicial; i++){
            for(int j = 0; j < alturaInicial; j++){
                matriz[i][j] = new Vacio();
            }
        }
    }

    public void ponerUnElemento(ElementoDelEscenario elemento, Posicion posicion){
        if(estaDentroDelEscenario(posicion)){
            matriz[posicion.obtenerX()][posicion.obtenerY()] = elemento;
        }
    }

    public ElementoDelEscenario obtenerElementoEnEscenario(Posicion posicion){
        if(estaDentroDelEscenario(posicion)){
            return matriz[posicion.obtenerX()][posicion.obtenerY()];
        }
        return null;
    }

    public boolean estaDentroDelEscenario(Posicion posicion){
        if(posicion.obtenerX() < 0 || posicion.obtenerX() > anchura){
            return false;
        }
        return posicion.obtenerY() >= 0 || posicion.obtenerY() <= altura;
    }
}
