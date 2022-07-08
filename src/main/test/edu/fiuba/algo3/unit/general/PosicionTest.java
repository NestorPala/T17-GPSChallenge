package edu.fiuba.algo3.unit.general;

import edu.fiuba.algo3.model.Movimiento.Posicion;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PosicionTest {
  @Test
  public void test01_puedoChequearSiDosPosicionesSonIguales() {
    Posicion p1 = new Posicion(0, 0);
    Posicion p2 = new Posicion(5, 5);
    Posicion p4 = new Posicion(5, 0);

    assertNotEquals(p1, p2);
    assertEquals(p1, p1);
    assertNotEquals(p4, p2);
    assertNotEquals(p2, null);
    assertNotEquals(p2, "(5, 5)");
    assertEquals(p1.toString(), "(0, 0)");
    assertEquals(p4.toString(), "(5, 0)");
  }
}
