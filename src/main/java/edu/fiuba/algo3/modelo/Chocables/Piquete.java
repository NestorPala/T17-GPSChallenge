package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.Penalizacion;
import edu.fiuba.algo3.modelo.Efectos.Retroceso;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class Piquete implements Chocable {
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        return new Penalizacion(2);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        return new Retroceso();
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        return new Retroceso();
    }
}
