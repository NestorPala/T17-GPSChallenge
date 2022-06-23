package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Entrega2Test {
  @Test
  public void test06_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Chocable sorpresaFavorable = new SorpresaFavorable();

    escenario.insertarChocable(sorpresaFavorable, new Posicion(0, 1));

    jugador.mover(Direccion.izquierda());

    assertEquals(0.8, jugador.puntaje());
  }

  @Test
  public void test07_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Chocable sorpresaDesfavorable = new SorpresaDesfavorable();

    escenario.insertarChocable(sorpresaDesfavorable, new Posicion(1, 2));

    jugador.mover(Direccion.arriba());

    assertEquals(1.25, jugador.puntaje());
  }

  @Test
  public void test08_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo auto = new Auto();
    Jugador jugador = new Jugador(auto, "Juan");
    Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
    Chocable pozo = new Pozo();

    escenario.insertarChocable(sorpresaCambioVehiculo, new Posicion(1, 0));
    escenario.insertarChocable(pozo, new Posicion(0, 0));

    jugador.mover(Direccion.abajo());
    jugador.mover(Direccion.izquierda());

    assertEquals(2, jugador.puntaje());
  }

  @Test
  public void test09_UnVehiculoSeEncuentraConUnControlPolicialYRecibePenalizacion() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Randomizer randomizerMock = mock(Randomizer.class);
    when(randomizerMock.aplicar(anyDouble())).thenReturn(true);
    Chocable controlPolicial = new ControlPolicial(randomizerMock);

    escenario.insertarChocable(controlPolicial, new Posicion(1, 2));

    jugador.mover(Direccion.arriba());

    assertEquals(4, jugador.puntaje());
  }

  @Test
  public void test09_UnVehiculoSeEncuentraConUnControlPolicialYNoRecibePenalizacion() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo moto = new Moto();
    Jugador jugador = new Jugador(moto, "Juan");
    Randomizer randomizerMock = mock(Randomizer.class);
    when(randomizerMock.aplicar(anyDouble())).thenReturn(false);
    Chocable controlPolicial = new ControlPolicial(randomizerMock);

    escenario.insertarChocable(controlPolicial, new Posicion(1, 2));

    jugador.mover(Direccion.arriba());

    assertEquals(1, jugador.puntaje());
  }

  @Test
  public void test10_UnTodoterrenoChocaConUnaSorpresaCambioDeVehiculoYLuegoChocaConUnPiquete() {
    Escenario escenario = Escenario.getInstance();
    Vehiculo todoterreno = new Todoterreno();
    Jugador jugador = new Jugador(todoterreno, "Juan");
    Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
    Chocable piquete = new Piquete();

    escenario.insertarChocable(sorpresaCambioVehiculo, new Posicion(1, 2));
    escenario.insertarChocable(piquete, new Posicion(1, 3));

    jugador.mover(Direccion.arriba());
    jugador.mover(Direccion.arriba());

    assertEquals(4, jugador.puntaje());
  }
}
