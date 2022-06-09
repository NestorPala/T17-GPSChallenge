package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Posicion;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PosicionTest {
    @Test
    public void puedoChequearSiDosPosicionesSonIguales() {
        Posicion p1 = new Posicion(0, 0);
        Posicion p2 = new Posicion(5, 5);
        Posicion p3 = new Posicion();
        Posicion p4 = new Posicion(5,0);

        assertNotEquals(p1, p2);
        assertEquals(p3, p1);
        assertEquals(p1,p1);
        assertNotEquals(p4,p2);
        assertNotEquals(p2, null);
        assertNotEquals(p1, new Auto());
    }
}
