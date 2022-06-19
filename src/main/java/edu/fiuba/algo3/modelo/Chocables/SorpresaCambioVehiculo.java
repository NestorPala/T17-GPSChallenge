package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.CambioDeVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class SorpresaCambioVehiculo implements Chocable {
    @Override
    public IEfecto devolverEfecto(Moto moto) {
        return new CambioDeVehiculo(new Auto());
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        return new CambioDeVehiculo(new Todoterreno());
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        return new CambioDeVehiculo(new Moto());
    }
}
