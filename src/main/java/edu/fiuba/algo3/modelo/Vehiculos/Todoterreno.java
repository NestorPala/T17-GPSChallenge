package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;

public class Todoterreno implements IVehiculo {
    private int pozosEncontrados;

    public Todoterreno() {
        this.pozosEncontrados = 0;
    }

    @Override
    public int chocar(Chocable elemento) {
        this.pozosEncontrados += 1;
        if (this.pozosEncontrados >= 3) {
            this.pozosEncontrados = 0;
            return elemento.obtenerPuntosDePenalizacion(this);
        }

        return 0;
    }
}
