package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Efectos.IEfecto;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Puntaje;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Chocables.Chocable;

public class Jugador {
    private IEstado estado;
    private Vehiculo vehiculo;
    private Posicion posicion;
    private Posicion posicionAnterior;
    private final Puntaje puntaje;
    private final String nombre;
    private final Escenario escenario = Escenario.getInstance();

    public Jugador(Vehiculo vehiculo, String nombre) {
        this.estado = new EstadoActivo();
        this.nombre = nombre;
        this.posicion = new Posicion(1,1);
        this.posicionAnterior = this.posicion;
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
        Posicion nuevaPosicion = this.vehiculo.mover(unaDireccion, posicion);
        this.puntaje.sumarMovimientos(1);
        if (this.escenario.contienePosicion(nuevaPosicion)) {
            this.posicionAnterior = this.posicion;
            this.posicion = nuevaPosicion;
            chocarObstaculos();
        }
    }

    private void chocarObstaculos() {
        //logger.
        Chocable chocable = this.escenario.obtenerChocable(this.posicion);
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

    public void retrocederPosicionAnterior() {
        this.posicion = this.posicionAnterior;
    }

    public void dejarDeJugar() {
        this.estado = new EstadoInactivo();
    }

    public boolean puedeSeguirJugando() {
        return estado.puedeSeguirJugando();
    }

    public String nombre() {
        return nombre;
    }
}
