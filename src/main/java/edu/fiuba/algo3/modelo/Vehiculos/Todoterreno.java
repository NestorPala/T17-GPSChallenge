package edu.fiuba.algo3.modelo.Vehiculos;
import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Logger;

public class Todoterreno extends Vehiculo {
    private int pozosEncontrados;

    public Todoterreno() {
        Logger logger = Logger.getInstance();
        logger.log("El jugador tiene como vehiculo una 4x4");
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
