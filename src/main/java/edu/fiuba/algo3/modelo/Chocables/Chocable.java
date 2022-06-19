package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public interface Chocable {
    Efecto devolverEfecto(Moto moto);

    Efecto devolverEfecto(Auto auto);

    Efecto devolverEfecto(Todoterreno todoterreno);
}
