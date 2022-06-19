package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.Porcentaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class SorpresaFavorable implements Chocable {
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        return new Porcentaje(-20);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        return new Porcentaje(-20);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        return new Porcentaje(-20);
    }
}
