package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.TamañoDelEscenarioInvalido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest {
  @Test
  public void noSePuedeCrearUnEscenarioConUnTamanioInvalido() {
    Executable tarea1 = () -> Escenario.getInstance(-2, 5);
    assertThrows(TamañoDelEscenarioInvalido.class, tarea1);

    Executable tarea2 = () -> Escenario.getInstance(5, -2);
    assertThrows(TamañoDelEscenarioInvalido.class, tarea2);
  }

  @Test
  public void noSePuedeColocarUnChocableFueraDeLosLimitesDelEscenario() {
    Escenario escenario = Escenario.getInstance(10,10);
    Pozo pozo = new Pozo();

    escenario.insertarChocable(pozo, new Posicion(11, 11));
    assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
  }

  @Test
  public void noSePuedeObtenerUnChocableDeUnLugarFueraDeLosLimitesDelEscenario() {
    Escenario escenario = Escenario.getInstance();

    assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
  }

  @Test
  public void soloPuedoTenerUnEscenarioDefinido(){
    Escenario escenario1 = Escenario.getInstance(11,11);
    Escenario escenario2 = Escenario.getInstance(12,12);

    assertEquals(escenario2,escenario1);
  }

  @Test
  public void SiChequeoUnElementoFueraDelEscenarioObtengoUnaRespuestaCorrecta() {
    Escenario escenario = Escenario.getInstance();

    assertFalse(escenario.contienePosicion(new Posicion(11, 5)));
    assertFalse(escenario.contienePosicion(new Posicion(-5, 5)));
    assertFalse(escenario.contienePosicion(new Posicion(5, 11)));
    assertFalse(escenario.contienePosicion(new Posicion(5, -5)));
  }
}
