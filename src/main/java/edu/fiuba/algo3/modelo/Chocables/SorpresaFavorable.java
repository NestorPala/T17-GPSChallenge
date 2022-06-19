package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Efectos.EfectoPocentaje;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class SorpresaFavorable implements Chocable {
    @Override
    public Efecto devolverEfecto(Moto moto) {
        return new EfectoPocentaje(-20);
    }

    @Override
    public Efecto devolverEfecto(Auto auto) {
        return new EfectoPocentaje(-20);
    }

    @Override
    public Efecto devolverEfecto(Todoterreno todoterreno) {
        return new EfectoPocentaje(-20);
    }
}
