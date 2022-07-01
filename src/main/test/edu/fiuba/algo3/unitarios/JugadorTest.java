package edu.fiuba.algo3.unitarios;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Direccion;
import edu.fiuba.algo3.model.Escenario;
import edu.fiuba.algo3.model.Posicion;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

  @Test
  public void aplicarUnMovimientoAlJugadorCambiaSuPosicion() {
    Vehiculo vehiculoInicial = new Moto();
    Jugador jugador = new Jugador(vehiculoInicial, "Juan");
    Escenario escenario = Escenario.getInstance();

    jugador.mover(Direccion.derecha());

    assertEquals(new Posicion(2, 1), jugador.posicion());
  }

  @Test
  public void moverAlJugadorHaciaUnaPosicionInvalidaNoHaceNada() {
    Jugador jugador = new Jugador(new Auto(), "Juan");
    Escenario escenario = Escenario.getInstance();
    escenario = escenario.reset();

    jugador.mover(Direccion.izquierda());
    jugador.mover(Direccion.izquierda());

    assertEquals(new Posicion(0,1), jugador.posicion());
  }

  @Test
  public void noSePuedeCrearUnJugadorConPosicionInicialInvalida() {}

  @Test
  public void noSePuedeCrearUnJugadorConUnVehiculoInicialInvalido() {}

  @Test
  public void laPuntuacionInicialDelJugadorEsCeroPuntos() {}

  @Test
  public void alPasarPorUnaCuadraSinObstaculosLaCantidadDePuntosEsCorrecta() {}

  @Test
  public void alPasarPorUnaCuadraConObstaculosLaCantidadDePuntosEsCorrecta() {}

  @Test
  public void alPasarDeVueltaPorElMismoObstaculoLaCantidadDePuntosEsCorrecta() {}

  @Test
  public void alPasarDeVueltaPorLaMismaSorpresaLaCantidadDePuntosEsCorrecta() {}

  @Test
  public void cuandoElJugadorLlegaALaMetaLaCantidadDePuntosEsCorrecta() {}
}
