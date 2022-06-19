package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Efectos.Efecto;
import edu.fiuba.algo3.modelo.Efectos.EfectoPenalizacion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;

public class ControlPolicial implements Chocable{
    private static final double PROBABILIDAD_MOTO = 0.2;
    private static final double PROBABILIDAD_AUTO = 0.5;
    private static final double PROBABILIDAD_TODOTERRENO = 0.7;
    private static final int PENALIZACION = 3;

    @Override
    public Efecto devolverEfecto(Moto moto) {
        if(this.esPenalizado(PROBABILIDAD_MOTO)) return new EfectoPenalizacion(PENALIZACION);
        return new EfectoPenalizacion(0);
    }

    @Override
    public Efecto devolverEfecto(Auto auto) {
        if(this.esPenalizado(PROBABILIDAD_AUTO)) return new EfectoPenalizacion(PENALIZACION);
        return new EfectoPenalizacion(0);
    }

    @Override
    public Efecto devolverEfecto(Todoterreno todoterreno) {
        if(this.esPenalizado(PROBABILIDAD_TODOTERRENO)) return new EfectoPenalizacion(PENALIZACION);
        return new EfectoPenalizacion(0);
    }

    public boolean esPenalizado(double probabilidadVehiculo){
        return (Math.random() >= probabilidadVehiculo);
    }
}