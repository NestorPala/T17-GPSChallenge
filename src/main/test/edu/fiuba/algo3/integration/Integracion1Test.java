package edu.fiuba.algo3.integration;

import edu.fiuba.algo3.model.Chocables.*;
import edu.fiuba.algo3.model.General.*;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Randomizador.Randomizer;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Integracion1Test {

  @Test
  public void test01_PartidaCompletaConUnJugador() {
    Logger.getInstance().activar();

    GPSChallenge juego = new GPSChallenge();

    Escenario escenario = Escenario.getInstance();
    escenario.insertarChocable(new Pozo(), new Posicion(1, 2));
    escenario.insertarChocable(new Piquete(), new Posicion(1, 3));
    Randomizer randomMock = mock(Randomizer.class);
    when(randomMock.random(anyDouble())).thenReturn(true);
    escenario.insertarChocable(new ControlPolicial(randomMock), new Posicion(2, 3));
    escenario.insertarChocable(new SorpresaCambioVehiculo(), new Posicion(2, 4));
    escenario.insertarChocable(new SorpresaFavorable(), new Posicion(3, 4));
    escenario.insertarChocable(new SorpresaDesfavorable(), new Posicion(3, 3));
    escenario.insertarChocable(new Meta(), new Posicion(3, 2));

    Jugador jugador = new Jugador(new Moto(), "Alejo");
    juego.agregarJugador(jugador);

    juego.mover(Direccion.arriba());
    juego.mover(Direccion.arriba());
    juego.mover(Direccion.derecha());
    juego.mover(Direccion.arriba());
    juego.mover(Direccion.derecha());
    juego.mover(Direccion.abajo());
    juego.mover(Direccion.abajo());

    assertEquals("Alejo", juego.obtenerMejorJugador().split(";")[0]);
    assertEquals("15.25", juego.obtenerMejorJugador().split(";")[1]);
  }
}
