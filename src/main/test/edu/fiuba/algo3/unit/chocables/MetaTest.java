package edu.fiuba.algo3.unit.chocables;

import edu.fiuba.algo3.model.Chocables.Chocable;
import edu.fiuba.algo3.model.Chocables.Meta;
import edu.fiuba.algo3.model.Efectos.IEfecto;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MetaTest {

  @Test
  public void test01_SiElJugadorLlegaALaMetaFinalizaElJuego() {
    Chocable meta = new Meta();
    Jugador j1 = new Jugador(new Moto(), "Pablo");
    Jugador j2 = new Jugador(new Auto(), "Roberto");
    Jugador j3 = new Jugador(new Todoterreno(), "Nestor");

    assertTrue(j1.puedeSeguirJugando());
    assertTrue(j2.puedeSeguirJugando());
    assertTrue(j3.puedeSeguirJugando());

    IEfecto e1 = meta.devolverEfecto(new Moto());
    IEfecto e2 = meta.devolverEfecto(new Auto());
    IEfecto e3 = meta.devolverEfecto(new Todoterreno());

    e1.aplicarEfecto(j1);
    e2.aplicarEfecto(j2);
    e3.aplicarEfecto(j3);

    assertFalse(j1.puedeSeguirJugando());
    assertFalse(j2.puedeSeguirJugando());
    assertFalse(j3.puedeSeguirJugando());

    assertEquals(meta.toString(), "meta");

  }
}
