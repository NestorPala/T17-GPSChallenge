package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Efectos.EfectoCambioDeVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class SorpresaCambioVehiculo implements Chocable {
    @Override
    public Efecto devolverEfecto(Moto moto) {
        return new EfectoCambioDeVehiculo(new Auto());
    }

    @Override
    public Efecto devolverEfecto(Auto auto) {
        return new EfectoCambioDeVehiculo(new Todoterreno());
    }

    @Override
    public Efecto devolverEfecto(Todoterreno todoterreno) {
        return new EfectoCambioDeVehiculo(new Moto());
    }
}
