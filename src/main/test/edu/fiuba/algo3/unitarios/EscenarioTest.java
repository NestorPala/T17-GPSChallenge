package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.ElementosDelEscenario.Pozo;
import edu.fiuba.algo3.modelo.ElementosDelEscenario.Vacio;
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

        assertTrue(escenario.obtenerElementoEnEscenario(posicionRandom) instanceof Vacio);

        escenario.ponerUnElemento(new Pozo(), new Posicion(8, 8));
        assertTrue(escenario.obtenerElementoEnEscenario(new Posicion(8, 8)) instanceof Pozo);
    }

    @Test
    public void puedoObtenerElementosDelEscenarioCorrectamente() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);
        Pozo pozo = new Pozo();

        assertTrue(escenario.obtenerElementoEnEscenario(new Posicion(5, 5)) instanceof Vacio);
        escenario.ponerUnElemento(pozo, new Posicion(5, 5));
        assertTrue(escenario.obtenerElementoEnEscenario(new Posicion(5, 5)) instanceof Pozo);
    }

    @Test
    public void siIntentoObtenerUnElementoEnUnaPosicionFueraDeLosLimitesReciboNull() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);

        assertNull(escenario.obtenerElementoEnEscenario(new Posicion(11, 11)));
    }

    @Test
    public void puedoSaberSiUnaPosicionEstaDentroDelEscenario() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(10, 10);

        assertFalse(escenario.estaDentroDelEscenario(new Posicion(11, 11)));
    }
}
