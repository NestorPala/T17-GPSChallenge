package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocables;

public class Todoterreno implements Vehiculo {
    private int pozosEncontrados;

    public Todoterreno() {
        this.pozosEncontrados = 0;
    }

    @Override
    public int chocar(Chocables elemento) {
        this.pozosEncontrados += 1;
        if (this.pozosEncontrados >= 3) {
            this.pozosEncontrados = 0;
            return elemento.obtenerPuntosDePenalizacion(this);
        }

        return 0;
    }
}
