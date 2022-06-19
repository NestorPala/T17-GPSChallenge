package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.Penalizacion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Pozo implements Chocable {
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        return new Penalizacion(3);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        return new Penalizacion(3);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        todoterreno.sumarPozo();
        if (todoterreno.obtenerPozos() >= 3) {
            return new Penalizacion(2);
        }
        return new Penalizacion(0);
    }
}
