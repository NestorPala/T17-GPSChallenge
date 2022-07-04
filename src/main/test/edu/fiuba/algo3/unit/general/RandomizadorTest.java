package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Randomizador.Randomizador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomizadorTest {

  @Test
  public void test01_elTestDaValoresCorrectos() {
    Randomizador randomizador = new Randomizador();

    assertFalse(randomizador.random(2));
    assertTrue(randomizador.random(0));
  }
}
