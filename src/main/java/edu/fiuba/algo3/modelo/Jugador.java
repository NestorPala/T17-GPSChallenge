package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Chocables.Chocable;

public class Jugador {
    private Vehiculo vehiculo;
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

    public void mover(Direccion unaDireccion) {
        Posicion nuevaPosicion = this.vehiculo.mover(unaDireccion, this.posicion);
        Escenario escenario = Escenario.getInstance();
        this.puntaje.sumarMovimientos(1);
        if (escenario.estaDentroDelEscenario(nuevaPosicion)) {
            this.posicion = nuevaPosicion;
            chocarObstaculos();
        }
    }

    private void chocarObstaculos() {
        Escenario escenario = Escenario.getInstance();
        Chocable chocable = escenario.obtenerChocable(this.posicion);
        IEfecto efecto = this.vehiculo.chocar(chocable);
        efecto.aplicarEfecto(this);
    }

    public void recibirPenalizacion(int penalizacion){
        this.puntaje.sumarMovimientos(penalizacion);
    }

    public void recibirPorcentaje(int porcentaje){
        this.puntaje.aplicarPorcentaje(porcentaje);
    }

    public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
        this.vehiculo = nuevoVehiculo;
    }
}
