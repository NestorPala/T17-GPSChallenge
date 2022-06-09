package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Chocables.Vacio;
import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.EscenarioConLimitesInvalidosError;
import edu.fiuba.algo3.modelo.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EscenarioTest {

    @Test
    public void siIntentoCrearUnEscenarioConLimitesInvalidosMeTiraError() {
        Executable tarea1 = () -> new Escenario(-5, 5);

        assertThrows(EscenarioConLimitesInvalidosError.class, tarea1);

        Executable tarea2 = () -> new Escenario(5, -5);

        assertThrows(EscenarioConLimitesInvalidosError.class, tarea2);
    }

    @Test
    public void chequeoUnaPosicionDelEscenarioInvalidaMeDaFalse() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);

        assertFalse(escenario.estaDentroDelEscenario(new Posicion(11, 11)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(5,15)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(15,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(-3,5)));
        assertFalse(escenario.estaDentroDelEscenario(new Posicion(6,-5)));
        assertTrue(escenario.estaDentroDelEscenario(new Posicion(2,8)));
        assertTrue(escenario.estaDentroDelEscenario(new Posicion(9,1)));
    }

    @Test
    public void ponerUnElementoFueraDeLosLimitesNoHaceNada() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);
        Pozo pozo = new Pozo();

        escenario.ponerUnElemento(pozo, new Posicion(11, 11));
        assertNull(escenario.obtenerElementoEnEscenario(new Posicion(11, 11)));
    }

    @Test
    public void puedoInicializarUnEscenarioConElementosVacios() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);
        Posicion posicionRandom = new Posicion(9, 9);

        escenario.ponerUnElemento(new Pozo(), new Posicion(8, 8));}

    @Test
    public void puedoObtenerElementosDelEscenarioCorrectamente() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);
        Pozo pozo = new Pozo();

        escenario.ponerUnElemento(pozo, new Posicion(5, 5));
    }

    @Test
    public void siIntentoObtenerUnElementoEnUnaPosicionFueraDeLosLimitesReciboNull() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);

        assertNull(escenario.obtenerElementoEnEscenario(new Posicion(11, 11)));
    }
}
