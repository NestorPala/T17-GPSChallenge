package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Chocables.Chocable;

public class Jugador {
    private final Vehiculo vehiculo;
    private Posicion posicion;
    private Puntaje puntaje;

    public Jugador(Vehiculo vehiculo) {
        this.posicion = new Posicion(1,1);
        this.vehiculo = vehiculo;
        this.puntaje = new Puntaje();
    }

    public Posicion posicion() {
        return this.posicion;
    }

    public double puntaje() {
        return this.puntaje.verMovimientos();
    }

    public void mover(Direccion unaDireccion, Escenario escenario) {
        Posicion nuevaPosicion = this.vehiculo.mover(unaDireccion, this.posicion);
        if (escenario.estaDentroDelEscenario(nuevaPosicion)) {
            this.posicion = nuevaPosicion;
            sumarPuntaje(escenario);
        }
    }

    private void sumarPuntaje(Escenario escenario) {
        Chocable chocable = escenario.obtenerChocable(this.posicion);
        //this.puntaje.sumarMovimientos(this.vehiculo.chocar(chocable) + 1);
        this.puntaje.sumarMovimientos(1);
        this.vehiculo.chocar(chocable, this.puntaje);
    }
}
