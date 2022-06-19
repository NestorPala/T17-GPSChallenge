package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Efectos.Efecto;

public class Moto extends Vehiculo {
    @Override
    public Efecto chocar(Chocable chocable) {
        return chocable.devolverEfecto(this);
    }
}
