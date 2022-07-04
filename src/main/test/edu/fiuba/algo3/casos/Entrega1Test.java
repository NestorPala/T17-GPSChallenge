package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Piquete;
import edu.fiuba.algo3.model.Chocables.Pozo;
import edu.fiuba.algo3.model.General.Direccion;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.General.Logger;
import edu.fiuba.algo3.model.General.Posicion;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega1Test {

  @Test
  public void test01_motoChocaPozoYEsPenalizadaConTresMovimientos() {
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
    Logger.getInstance().activar();
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
