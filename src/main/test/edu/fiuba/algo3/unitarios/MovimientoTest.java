package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoTest {
    @Test
    public void sePuedeCrearunMovimientoCorrectamente(){
        Movimiento movimiento = new Movimiento(3,7);

        assertEquals(movimiento.obtenerX(),3);
        assertEquals(movimiento.obtenerY(),7);
    }

}
