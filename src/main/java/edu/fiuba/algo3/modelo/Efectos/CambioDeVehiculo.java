package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class CambioDeVehiculo implements IEfecto{

    private Vehiculo vehiculo;

    public CambioDeVehiculo(Vehiculo nuevoVehiculo){
        this.vehiculo = nuevoVehiculo;
        Logger logger = Logger.getInstance();
        logger.log("El jugador cambio de vehiculo");
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.cambiarVehiculo(this.vehiculo);
    }
}
