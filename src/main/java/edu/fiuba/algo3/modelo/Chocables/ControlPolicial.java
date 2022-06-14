package edu.fiuba.algo3.modelo.Chocables;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Puntaje;

public class ControlPolicial implements Chocable{
    private static final double PROBABILIDAD_MOTO = 0.2;
    private static final double PROBABILIDAD_AUTO = 0.5;
    private static final double PROBABILIDAD_TODOTERRENO = 0.7;
    private static final int PENALIZACION = 3;

    @Override
    public Vehiculo aplicarPenalizacion(Moto moto, Puntaje puntaje) {
        if(this.esPenalizado(PROBABILIDAD_MOTO)) puntaje.sumarMovimientos(PENALIZACION);
        return moto;
    }

    @Override
    public Vehiculo aplicarPenalizacion(Auto auto, Puntaje puntaje) {
        if(this.esPenalizado(PROBABILIDAD_AUTO)) puntaje.sumarMovimientos(PENALIZACION);
        return auto;
    }

    @Override
    public Vehiculo aplicarPenalizacion(Todoterreno todoterreno, Puntaje puntaje) {
        if(this.esPenalizado(PROBABILIDAD_TODOTERRENO)) puntaje.sumarMovimientos(PENALIZACION);
        return todoterreno;
    }

    public boolean esPenalizado(double probabilidadVehiculo){
        return (Math.random() >= probabilidadVehiculo);
    }
}