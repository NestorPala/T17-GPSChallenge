package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Efectos.Penalizacion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class ControlPolicial implements Chocable{
    private static final double PROBABILIDAD_MOTO = 0.2;
    private static final double PROBABILIDAD_AUTO = 0.5;
    private static final double PROBABILIDAD_TODOTERRENO = 0.7;
    private static final int PENALIZACION = 3;

    @Override
    public IEfecto devolverEfecto(Moto moto) {
        if(this.esPenalizado(PROBABILIDAD_MOTO)) return new Penalizacion(PENALIZACION);
        return new Penalizacion(0);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        if(this.esPenalizado(PROBABILIDAD_AUTO)) return new Penalizacion(PENALIZACION);
        return new Penalizacion(0);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        if(this.esPenalizado(PROBABILIDAD_TODOTERRENO)) return new Penalizacion(PENALIZACION);
        return new Penalizacion(0);
    }

    public boolean esPenalizado(double probabilidadVehiculo){
        return (Math.random() >= probabilidadVehiculo);
    }
}