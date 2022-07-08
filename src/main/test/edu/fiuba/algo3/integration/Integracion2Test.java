package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.model.Chocables.*;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Randomizador.Randomizer;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Integracion2Test {

  @Test
  public void test01_PartidaCompletaConDosJugadores() {
    GPSChallenge juego = new GPSChallenge();

    Escenario escenario = Escenario.getInstance();
    escenario = escenario.reset();
    escenario.insertarChocable(new Pozo(), new Posicion(1, 2));
    escenario.insertarChocable(new Piquete(), new Posicion(1, 3));
    Randomizer randomMock = mock(Randomizer.class);
    when(randomMock.random(anyDouble())).thenReturn(true);
    escenario.insertarChocable(new ControlPolicial(randomMock), new Posicion(2, 3));
    escenario.insertarChocable(new SorpresaCambioVehiculo(), new Posicion(2, 4));
    escenario.insertarChocable(new SorpresaFavorable(), new Posicion(3, 4));
    escenario.insertarChocable(new SorpresaDesfavorable(), new Posicion(3, 3));
    escenario.insertarChocable(new Meta(), new Posicion(3, 2));

    Jugador jugador1 = new Jugador(new Moto(), "Alejo");
    juego.agregarJugador(jugador1);
    Jugador jugador2 = new Jugador(new Auto(), "Juan");
    juego.agregarJugador(jugador2);

    juego.mover(Direccion.arriba());
    juego.mover(Direccion.arriba());
    juego.mover(Direccion.derecha());
    juego.mover(Direccion.arriba());
    juego.mover(Direccion.derecha());
    juego.mover(Direccion.abajo());
    juego.mover(Direccion.abajo());

    juego.mover(Direccion.derecha());
    juego.mover(Direccion.derecha());
    juego.mover(Direccion.arriba());

    String[] top = juego.obtenerTop10();

    assertEquals("Juan", top[0].split(";")[0]);
    assertEquals("3.0", top[0].split(";")[1]);

    assertEquals("Alejo", top[1].split(";")[0]);
    assertEquals("15.25", top[1].split(";")[1]);

    assertEquals("Juan", juego.obtenerMejorJugador().split(";")[0]);
    assertEquals("3.0", juego.obtenerMejorJugador().split(";")[1]);
  }
}
