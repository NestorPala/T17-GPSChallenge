package edu.fiuba.algo3.model.Jugador;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Puntaje.Puntaje;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

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
    this.posicion = new Posicion(1, 1);
    this.posicionAnterior = this.posicion;
    this.vehiculo = vehiculo;
    this.puntaje = new Puntaje();
    Logger.getInstance().log("Se creó el usuario " + this.nombre);
    Logger.getInstance().log(this.nombre + " Tiene como vehiculo " + vehiculo.toString());
  }

  public Posicion posicion() {
    return this.posicion;
  }

  public double puntaje() {
    return this.puntaje.verMovimientos();
  }

  public void mover(Direccion unaDireccion) {
    if (!puedeSeguirJugando()) {
      return;
    }

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
    Logger.getInstance()
        .log(
            this.nombre
                + " iba con "
                + this.vehiculo.toString()
                + " y se chocó con "
                + chocable.toString());
    IEfecto efecto = this.vehiculo.chocar(chocable);
    efecto.aplicarEfecto(this);
  }

  public void recibirPenalizacion(int penalizacion) {
    Logger.getInstance()
        .log(this.nombre + " recibe una penalización de: " + penalizacion + " puntos");
    this.puntaje.sumarMovimientos(penalizacion);
  }

  public void recibirPorcentaje(int porcentaje) {
    Logger.getInstance()
        .log(this.nombre + " recibe un porcentaje de: " + porcentaje + "% a sus puntos");
    this.puntaje.aplicarPorcentaje(porcentaje);
  }

  public void cambiarVehiculo(Vehiculo nuevoVehiculo) {
    this.vehiculo = nuevoVehiculo;
    Logger.getInstance()
        .log(this.nombre() + " cambio de vehiculo, nuevo vehiculo: " + this.vehiculo.toString());
  }

  public void retrocederPosicionAnterior() {
    this.posicion = this.posicionAnterior;
    Logger.getInstance()
        .log("El jugador " + this.nombre() + " retrocedió una posición a causa de un choque");
  }

  public void dejarDeJugar() {
    this.estado = new EstadoInactivo();
    Logger.getInstance().log("El jugador " + this.nombre() + " llego a la meta");
    Logger.getInstance().log("El jugador " + this.nombre() + " dejo de jugar");
  }

  public boolean puedeSeguirJugando() {
    return estado.puedeSeguirJugando();
  }

  public String nombre() {
    return nombre;
  }

  public Vehiculo vehiculo() {
    return this.vehiculo;
  }
}
