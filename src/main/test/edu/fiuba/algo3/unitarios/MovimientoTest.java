package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Movimiento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovimientoTest {
    @Test
    public void sePuedeCrearUnMovimientoCorrectamente() {
        Movimiento movimiento = new Movimiento(3, 7);

        assertEquals(movimiento.obtenerX(), 3);
        assertEquals(movimiento.obtenerY(), 7);
    }

    @Test
    public void sePuedeCrearUnMovimientoSinParametrosCorrectamente(){
        Movimiento movimiento = new Movimiento();

        assertEquals(movimiento.obtenerX(), 0);
        assertEquals(movimiento.obtenerY(), 0);
    }

}
