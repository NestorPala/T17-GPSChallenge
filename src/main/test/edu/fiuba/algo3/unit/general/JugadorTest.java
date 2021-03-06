package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Chocables.Meta;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Movimiento.Direccion;
import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
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

    assertEquals(jugador.vehiculo().toString(), "moto");
    assertEquals(new Posicion(2, 1), jugador.posicion());
  }

  @Test
  public void test02_moverAlJugadorHaciaUnaPosicionInvalidaNoHaceNada() {
    Escenario escenario = Escenario.getInstance().reset();
    Jugador jugador = new Jugador(new Auto(), "Juan");

    jugador.mover(Direccion.izquierda());
    jugador.mover(Direccion.izquierda());

    assertEquals(jugador.vehiculo().toString(), "auto");
    assertEquals(new Posicion(0, 1), jugador.posicion());
  }

  @Test
  public void test03_elJugadorSeCreaConElVehiculoCorrecto() {
    Vehiculo todoterreno = new Todoterreno();

    Jugador jugador = new Jugador(todoterreno, "Pablo");

    assertEquals(jugador.vehiculo().toString(), "todoterreno");
    assertEquals(jugador.vehiculo(), todoterreno);
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
}
