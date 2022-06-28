package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {
  @Test
  public void test01_motoChocaPozoYEsPenalizadaConTresMovimientos() {

    Logger logger = Logger.getInstance();
    logger.activar();

    Escenario escenario = Escenario.getInstance();
    Vehiculo moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Chocable pozo = new Pozo();

    escenario.insertarChocable(pozo, new Posicion(2, 1));

    jugador.mover(Direccion.derecha());

    assertEquals(4, jugador.puntaje());
  }

  @Test
  public void test02_autoChocaPozoYEsPenalizadoConTresMovimientos() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo auto = new Auto();
    Jugador jugador = new Jugador(auto, "Juan");
    Chocable pozo = new Pozo();

    escenario.insertarChocable(pozo, new Posicion(2, 1));

    jugador.mover(Direccion.derecha());

    assertEquals(4, jugador.puntaje());
  }

  @Test
  public void test03_todoterrenoChocaPozoYNoEsPenalizado() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo todoterreno = new Todoterreno();
    Jugador jugador = new Jugador(todoterreno, "Juan");
    Chocable pozo = new Pozo();

    escenario.insertarChocable(pozo, new Posicion(2, 1));

    jugador.mover(Direccion.derecha());

    assertEquals(1, jugador.puntaje());
  }

  @Test
  public void test04_motoChocaConPiqueteYEsPenalizadoConDosMovimientos() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Chocable piquete = new Piquete();

    escenario.insertarChocable(piquete, new Posicion(2, 1));

    jugador.mover(Direccion.derecha());

    assertEquals(3, jugador.puntaje());
  }

  @Test
  public void test05_todoterrenoChocaConTresPozosYEsPenalizadoConDosMovimientos() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo todoterreno = new Todoterreno();
    Jugador jugador = new Jugador(todoterreno, "Juan");
    Chocable pozo = new Pozo();

    // Pongo los pozos
    escenario.insertarChocable(pozo, new Posicion(2, 1));
    escenario.insertarChocable(pozo, new Posicion(3, 1));
    escenario.insertarChocable(pozo, new Posicion(4, 1));

    // Muevo tres veces al jugador
    jugador.mover(Direccion.derecha());
    jugador.mover(Direccion.derecha());
    jugador.mover(Direccion.derecha());

    assertEquals(5, jugador.puntaje());
  }
}
