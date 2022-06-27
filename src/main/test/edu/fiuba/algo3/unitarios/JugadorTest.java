package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

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
