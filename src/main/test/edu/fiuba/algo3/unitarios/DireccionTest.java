package edu.fiuba.algo3.unitarios;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Direccion;
import edu.fiuba.algo3.model.Posicion;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DireccionTest {

    @Test
    public void lasDireccionesSeCalculanCorrectamente(){
        Direccion direccion = new Direccion(1, 1);

        Posicion nuevaPos = direccion.calcularNuevaPosicion(new Posicion(1,1));
        assertEquals(2,nuevaPos.x());
        assertEquals(2,nuevaPos.y());
    }
    
}
