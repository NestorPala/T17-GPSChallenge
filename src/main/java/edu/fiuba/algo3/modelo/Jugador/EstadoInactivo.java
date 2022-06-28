package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;

public class EstadoInactivo implements IEstado {
    public EstadoInactivo() {}

    @Override
    public boolean puedeSeguirJugando() {
        return false;
    }
}