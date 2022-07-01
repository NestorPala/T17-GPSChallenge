package edu.fiuba.algo3.model.Jugador;

import edu.fiuba.algo3.model.*;
import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class Jugador {
    private IEstado estado;
    private Vehiculo vehiculo;
    private Posicion posicion;
    private Posicion posicionAnterior;
    private final Puntaje puntaje;
    private final String nombre;
    private final Escenario escenario = Escenario.getInstance();
    private final Logger logger = Logger.getInstance();

    public Jugador(Vehiculo vehiculo, String nombre) {
        this.estado = new EstadoActivo();
        this.nombre = nombre;
        this.posicion = new Posicion(1,1);
        this.posicionAnterior = this.posicion;
        this.vehiculo = vehiculo;
        this.puntaje = new Puntaje();
        logger.log("Se creó el usuario " + this.nombre);
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
        logger.log("El jugador cambio de vehiculo");
    }

    public void retrocederPosicionAnterior() {
        this.posicion = this.posicionAnterior;
        logger.log("El jugador retrocedió una posición");
    }

    public void dejarDeJugar() {
        this.estado = new EstadoInactivo();
        logger.log("Se termino el juego");
    }

    public boolean puedeSeguirJugando() {
        return estado.puedeSeguirJugando();
    }

    public String nombre() {
        return nombre;
    }

    public Vehiculo vehiculo(){ return this.vehiculo;}
}
