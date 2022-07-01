package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Penalizacion;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class Vacio implements Chocable {
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        return new Penalizacion(0);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        return new Penalizacion(0);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        return new Penalizacion(0);
    }
}
