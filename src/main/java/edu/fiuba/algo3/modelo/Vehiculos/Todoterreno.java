package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Puntaje;

public class Todoterreno extends Vehiculo {
    private int pozosEncontrados;

    public Todoterreno() {
        this.pozosEncontrados = 0;
    }

    @Override
    public Vehiculo chocar(Chocable chocable, Puntaje puntaje) {
        this.pozosEncontrados += 1;
        if (this.pozosEncontrados >= 3) {
            this.pozosEncontrados = 0;
            return chocable.aplicarPenalizacion(this, puntaje);
        }
        return this;
    }
}
