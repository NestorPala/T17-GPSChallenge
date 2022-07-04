package edu.fiuba.algo3.model.Chocables;

import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Efectos.Penalizacion;
import edu.fiuba.algo3.model.Randomizador.Randomizer;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;

public class ControlPolicial implements Chocable{
    private static final double PROBABILIDAD_MOTO = 0.2;
    private static final double PROBABILIDAD_AUTO = 0.5;
    private static final double PROBABILIDAD_TODOTERRENO = 0.7;
    private static final int PENALIZACION = 3;

    private final Randomizer randomizador;

    public ControlPolicial(Randomizer randomizer) {
        this.randomizador = randomizer;
    }

    @Override
    public IEfecto devolverEfecto(Moto moto) {
        Logger.getInstance().log("El jugador iba con una moto y se choco con un control policial");
        if(this.randomizador.random(PROBABILIDAD_MOTO)) return new Penalizacion(PENALIZACION);
        return new Penalizacion(0);
    }

    @Override
    public IEfecto devolverEfecto(Auto auto) {
        Logger.getInstance().log("El jugador iba con un auto y se choco con un control policial");
        if(this.randomizador.random(PROBABILIDAD_AUTO)) return new Penalizacion(PENALIZACION);
        return new Penalizacion(0);
    }

    @Override
    public IEfecto devolverEfecto(Todoterreno todoterreno) {
        Logger.getInstance().log("El jugador iba con una 4x4 y se choco con un control policial");
        if(this.randomizador.random(PROBABILIDAD_TODOTERRENO)) return new Penalizacion(PENALIZACION);
        return new Penalizacion(0);
    }
}