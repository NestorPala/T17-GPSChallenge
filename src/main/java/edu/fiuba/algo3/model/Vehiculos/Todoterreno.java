package edu.fiuba.algo3.model.Vehiculos;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;

public class Todoterreno extends Vehiculo {
    private int pozosEncontrados;

    public Todoterreno() {
        Logger.getInstance().log("El jugador tiene como vehiculo una 4x4");
        this.pozosEncontrados = 0;
    }

    public void sumarPozo() {
        this.pozosEncontrados += 1;
    }

    public int obtenerPozos() {
        return this.pozosEncontrados;
    }

    @Override
    public IEfecto chocar(Chocable chocable) {
        return chocable.devolverEfecto(this);
    }
}
