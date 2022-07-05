package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Efectos.EfectoSorpresata;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class Sorpresata implements Chocable {

    public IEfecto devolverEfecto(Moto moto) {
        Logger.getInstance().log("El jugador iba con una moto y se choco con una sorpresata");
        return new EfectoSorpresata();
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        Logger.getInstance().log("El jugador iba con un auto y se choco con una sorpresata");
        return new EfectoSorpresata();
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        Logger.getInstance().log("El jugador iba con una 4x4 y se choco con una sorpresata");
        return new EfectoSorpresata();
    }

    @Override
    public String toString() {
        return "sorpresata";
    }
}
