package edu.fiuba.algo3.modelo.Vehiculos;
import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Puntaje;

public class Todoterreno extends Vehiculo {
    private int pozosEncontrados;

    public Todoterreno() {
        this.pozosEncontrados = 0;
    }

    public void sumarPozo() {
        this.pozosEncontrados += 1;
    }

    public int obtenerPozos() {
        return this.pozosEncontrados;
    }

    @Override
    public Vehiculo chocar(Chocable chocable, Puntaje puntaje) {
        return chocable.aplicarPenalizacion(this, puntaje);
    }
}
