package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class CambioDeVehiculo implements IEfecto{

    private Vehiculo vehiculo;

    public CambioDeVehiculo(Vehiculo nuevoVehiculo){
        this.vehiculo = nuevoVehiculo;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.cambiarVehiculo(this.vehiculo);
    }
}
