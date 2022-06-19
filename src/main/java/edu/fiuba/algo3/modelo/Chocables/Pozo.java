package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Efectos.EfectoPenalizacion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Pozo implements Chocable {
    @Override
    public Efecto devolverEfecto(Moto moto) {
        return new EfectoPenalizacion(3);
    }

    @Override
    public Efecto devolverEfecto(Auto auto) {
        return new EfectoPenalizacion(3);
    }

    @Override
    public Efecto devolverEfecto(Todoterreno todoterreno) {
        todoterreno.sumarPozo();
        if (todoterreno.obtenerPozos() >= 3) {
            return new EfectoPenalizacion(2);
        }
        return new EfectoPenalizacion(0);
    }
}
