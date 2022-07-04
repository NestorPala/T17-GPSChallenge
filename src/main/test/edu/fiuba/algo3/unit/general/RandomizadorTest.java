package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Randomizador.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomizadorTest {

  @Test
  public void test01_elTestDaValoresCorrectos() {
    Random randomizador = new Random();

    assertFalse(randomizador.random(2));
    assertTrue(randomizador.random(0));
  }
}
