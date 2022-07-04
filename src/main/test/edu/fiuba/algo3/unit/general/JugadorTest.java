package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Chocables.Meta;
import edu.fiuba.algo3.model.General.Direccion;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.General.Posicion;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {

  @Test
  public void test01_aplicarUnMovimientoAlJugadorCambiaSuPosicion() {
    Vehiculo vehiculoInicial = new Moto();
    Jugador jugador = new Jugador(vehiculoInicial, "Juan");
    Escenario escenario = Escenario.getInstance();

    jugador.mover(Direccion.derecha());

    assertEquals(new Posicion(2, 1), jugador.posicion());
  }

  @Test
  public void test02_moverAlJugadorHaciaUnaPosicionInvalidaNoHaceNada() {
    Escenario escenario = Escenario.getInstance().reset();
    Jugador jugador = new Jugador(new Auto(), "Juan");

    jugador.mover(Direccion.izquierda());
    jugador.mover(Direccion.izquierda());

    assertEquals(new Posicion(0, 1), jugador.posicion());
  }

  @Test
  public void test03_elJugadorSeCreaConElVehiculoCorrecto() {
    Vehiculo auto = new Auto();

    Jugador jugador = new Jugador(auto, "Pablo");

    assertEquals(jugador.vehiculo(), auto);
  }

  @Test
  public void test04_elJugadorNoSeMoveraSiYaLlegoALaMeta() {
    Escenario escenario = Escenario.getInstance().reset();
    escenario.insertarChocable(new Meta(), new Posicion(2, 1));

    Jugador jugador = new Jugador(new Moto(), "Pablo");

    assertEquals(jugador.posicion(), new Posicion(1, 1));
    jugador.mover(Direccion.derecha());
    assertEquals(jugador.posicion(), new Posicion(2, 1));
    jugador.mover(Direccion.derecha());
    assertEquals(jugador.posicion(), new Posicion(2, 1));
  }

  /*  @Test
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
  public void cuandoElJugadorLlegaALaMetaLaCantidadDePuntosEsCorrecta() {}*/
}
