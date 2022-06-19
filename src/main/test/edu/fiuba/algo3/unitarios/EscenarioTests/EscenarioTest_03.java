package edu.fiuba.algo3.unitarios.EscenarioTests;

import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest_03 {
    @Test
    public void noSePuedeObtenerUnChocableDeUnLugarFueraDeLosLimitesDelEscenario(){
         Escenario escenario = Escenario.getInstance();

        assertNull(escenario.obtenerChocable(new Posicion(11, 11)));
    }
}
