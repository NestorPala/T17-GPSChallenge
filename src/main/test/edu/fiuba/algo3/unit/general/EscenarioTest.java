package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Chocables.Pozo;
import edu.fiuba.algo3.model.Exceptions.TamanioDelEscenarioInvalido;
import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest {
  @Test
  public void test01_noSePuedeCrearUnEscenarioConUnTamanioInvalido() {
    Executable tarea1 = () -> Escenario.getInstance(-2, 5);
    assertThrows(TamanioDelEscenarioInvalido.class, tarea1);

    Executable tarea2 = () -> Escenario.getInstance(5, -2);
    assertThrows(TamanioDelEscenarioInvalido.class, tarea2);
  }

  @Test
  public void test02_noSePuedeColocarUnChocableFueraDeLosLimitesDelEscenario() {
    Escenario escenario = Escenario.getInstance(10, 10);
    Pozo pozo = new Pozo();

    escenario.insertarChocable(pozo, new Posicion(11, 11));
    assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
  }

  @Test
  public void test03_noSePuedeObtenerUnChocableDeUnLugarFueraDeLosLimitesDelEscenario() {
    Escenario escenario = Escenario.getInstance();
    assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
  }

  @Test
  public void test04_soloPuedoTenerUnEscenarioDefinido() {
    Escenario escenario1 = Escenario.getInstance(11, 11);
    Escenario escenario2 = Escenario.getInstance(12, 12);

    assertEquals(escenario2, escenario1);
  }

  @Test
  public void test05_SiChequeoUnElementoFueraDelEscenarioObtengoUnaRespuestaCorrecta() {
    Escenario escenario = Escenario.getInstance();

    assertFalse(escenario.contienePosicion(new Posicion(11, 5)));
    assertFalse(escenario.contienePosicion(new Posicion(-5, 5)));
    assertFalse(escenario.contienePosicion(new Posicion(5, 11)));
    assertFalse(escenario.contienePosicion(new Posicion(5, -5)));
  }

  @Test
  public void test06_sePuedeCrearUnEscenarioDefinido() {
    Escenario escenario = Escenario.getInstance().reset();

    assertEquals(escenario.alto(), 10);
    assertEquals(escenario.ancho(), 10);
  }
}
