package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.ElementosDelEscenario.Pozo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosTest {

    @Test
    public void motoChocaPozoYEsPenalizadaConTresMovimientos() throws EscenarioConLimitesInvalidosError {
        Escenario escenario = new Escenario(20,20);
        Moto moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1,1), moto);
        Pozo pozo = new Pozo();
        Movimiento movimiento = new Movimiento();

        // El jugador inicia con 0 penalizaciones y 0 movimientos.
        assertEquals(0, jugador.totalPenalizaciones());
        assertEquals(0, jugador.movimientosRealizados());

        // Pongo el pozo
        escenario.ponerUnElemento(pozo,new Posicion(2,1));

        // Chequeo que se puso
        assertTrue(escenario.obtenerElementoEnEscenario(new Posicion(2,1)) instanceof Pozo);

        // Muevo al jugador a la nueva posicion
        jugador.moverse(new Movimiento(1,0), escenario);

        // Chequeo la nueva posicion del jugador
        assertEquals(jugador.posicionDelJugador(), new Posicion(2,1));

        // Chequeo si se aumentaron la cantidad de penalizaciones
        assertEquals(jugador.totalPenalizaciones(), 3);

        // Chequeo si se aumentaron los movimientos
        assertEquals(jugador.movimientosRealizados(), 1);

        // Vuelvo a mover y pruebo si funciona sin chocar
        jugador.moverse(new Movimiento(1,0), escenario);
        assertEquals(jugador.movimientosRealizados(),2);
        assertEquals(jugador.totalPenalizaciones(),3);
    }
}
