package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Movimiento.IMovimiento;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Jugador {
    private int penalizaciones;
    private final IVehiculo vehiculo;
    private Posicion posicion;
    private int cantidadMovimientos;

    public Jugador(Posicion posInicial, IVehiculo vehiculo) {
        this.posicion = posInicial;
        this.vehiculo = vehiculo;
        this.cantidadMovimientos = 0;
        this.penalizaciones = 0;
    }

    public Posicion posicionDelJugador() {
        return this.posicion;
    }

    public int puntaje(){ return (this.cantidadMovimientos + this.penalizaciones);}

    public void moverse(IMovimiento IMovimiento, Escenario escenario) {
        Posicion nuevaPosicion = new Posicion(posicion.x(), posicion.y());

        nuevaPosicion.moverseDesdePosicionInicial(IMovimiento);

        if (escenario.estaDentroDelEscenario(nuevaPosicion)) {
            this.penalizaciones += this.vehiculo.chocar(escenario.obtenerChocableEnPosicion(nuevaPosicion));
            this.posicion = nuevaPosicion;
            this.cantidadMovimientos++;
        }
    }
}
