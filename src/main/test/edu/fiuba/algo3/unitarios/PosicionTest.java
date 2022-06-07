package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PosicionTest {
    @Test
    public void puedoChequearSiDosPosicionesSonIguales() {
        Posicion p1 = new Posicion(0, 0);
        Posicion p2 = new Posicion(5, 5);
        Posicion p3 = new Posicion();

        assertNotEquals(p1, p2);
        assertEquals(p3, p1);
    }
}
