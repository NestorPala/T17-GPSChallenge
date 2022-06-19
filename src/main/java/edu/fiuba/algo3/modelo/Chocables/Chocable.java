package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public interface Chocable {
    IEfecto devolverEfecto(Moto moto);

    IEfecto devolverEfecto(Auto auto);

    IEfecto devolverEfecto(Todoterreno todoterreno);
}
