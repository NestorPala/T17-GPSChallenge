package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.IChocable;
import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.Movimiento.Derecha;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosTest {



    @Test
    public void motoChocaPozoYEsPenalizadaConTresMovimientos() 
    throws EscenarioConLimitesInvalidosError 
    {
        Escenario escenario = new Escenario(20, 20);
        IVehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        IChocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        // jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 4);
    }



    @Test
    public void autoChocaPozoYEsPenalizadoConTresMovimientos() 
    throws EscenarioConLimitesInvalidosError 
    {
        Escenario escenario = new Escenario(20, 20);
        IVehiculo auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(1, 1), auto);
        IChocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        // jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 4);
    }



    @Test
    public void todoterrenoChocaPozoYNoEsPenalizado() 
    throws EscenarioConLimitesInvalidosError 
    {
        Escenario escenario = new Escenario(20, 20);
        IVehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(new Posicion(1, 1), todoterreno);
        IChocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        // jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 1);
    }



    @Test
    public void motoChocaConPiqueteYEsPenalizadoConDosMovimientos() 
    throws EscenarioConLimitesInvalidosError 
    {
        Escenario escenario = new Escenario(20, 20);
        IVehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        IChocable piquete = new Piquete();

        escenario.insertarChocable(piquete, new Posicion(2, 1));

        // jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 3);
    }



    @Test
    public void todoterrenoChocaConTresPozosYEsPenalizadoConDosMovimientos() 
    throws EscenarioConLimitesInvalidosError 
    {
        Escenario escenario = new Escenario(20, 20);
        IVehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(new Posicion(1, 1), todoterreno);
        IChocable pozo = new Pozo();

        // Pongo los pozos
        escenario.insertarChocable(pozo, new Posicion(2, 1));
        escenario.insertarChocable(pozo, new Posicion(3, 1));
        escenario.insertarChocable(pozo, new Posicion(4, 1));

        //Muevo tres veces al jugador
        // jugador.moverse(new Movimiento(1, 0), escenario);
        // jugador.moverse(new Movimiento(1, 0), escenario);
        // jugador.moverse(new Movimiento(1, 0), escenario);
        jugador.moverse(new Derecha(), escenario);
        jugador.moverse(new Derecha(), escenario);
        jugador.moverse(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 5);
    }



}
