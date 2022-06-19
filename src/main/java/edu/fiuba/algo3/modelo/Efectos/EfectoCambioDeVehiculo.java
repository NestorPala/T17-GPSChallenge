package edu.fiuba.algo3.modelo.Efectos;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class EfectoCambioDeVehiculo implements Efecto{

    private Vehiculo vehiculo;

    public EfectoCambioDeVehiculo(Vehiculo nuevoVehiculo){
        this.vehiculo = nuevoVehiculo;
    }

    @Override
    public void aplicarEfecto(Jugador jugador) {
        jugador.cambiarVehiculo(this.vehiculo);
    }
}
