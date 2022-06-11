package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Movimiento.Arriba;
import edu.fiuba.algo3.modelo.Movimiento.IMovimiento;
import edu.fiuba.algo3.modelo.Movimiento.Izquierda;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {




    @Test
    public void unJugadorInicializaCorrectamente() {
        Posicion posicionInicial = new Posicion(1, 1);
        IVehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(posicionInicial, vehiculoInicial);

        assertEquals(jugador.puntaje(), 0);
    }




    @Test
    public void puedoCambiarAlJugadorDePosicion() 
    throws PosicionDelEscenarioInvalida 
    {
        Posicion posicionInicial = new Posicion();
        IVehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(posicionInicial, vehiculoInicial);
        Escenario escenario = new Escenario(10, 10);
        IMovimiento movimiento = new Arriba();

        jugador.mover(movimiento, escenario);

        assertEquals(jugador.posicion(), new Posicion(0, 1));
    }




    @Test
    public void CambioAlJugadorAUnaPosicionInvalidaNoHaceNada() 
    throws PosicionDelEscenarioInvalida 
    {
        Posicion posicionInicial = new Posicion();
        IVehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(posicionInicial, vehiculoInicial);
        Escenario escenario = new Escenario(10, 10);
        IMovimiento movimiento = new Izquierda();
        
        jugador.mover(movimiento, escenario);

        assertEquals(jugador.posicion(), posicionInicial);
    }



}
