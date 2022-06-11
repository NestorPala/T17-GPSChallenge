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

        jugador.mover(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 4);
    }



    // Escenario escenario = new Escenario();
    // Chocable pozo1 = new Pozo(); 
    // Chocable pozo2 = new Pozo(); 
    // Chocable piquete1 = new Piquete(); 

    // Escenario.insertarChocables([pozo1, pozo2, piquete1])
    // // posiciones: 2,3 - 6,5 - 0,4

    // if vehiculo.choco(pozo1):
    //     hacer algo
    
    // class vehiculo {
    //     bool choco(chocable) {
    //         this.posicion.equals(chocable.posicion())
    //     }
    // }

    // for i in range(5):
    //     escenario.insertarchocables(new Pozo())
    
    // for i in range(6):
    //     escenario.insertarchocables(new Piquete())


    
    @Test
    public void autoChocaPozoYEsPenalizadoConTresMovimientos() 
    throws EscenarioConLimitesInvalidosError 
    {
        Escenario escenario = new Escenario(20, 20);
        IVehiculo auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(1, 1), auto);
        IChocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(new Derecha(), escenario);

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

        jugador.mover(new Derecha(), escenario);

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

        jugador.mover(new Derecha(), escenario);

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

        // Muevo tres veces al jugador
        jugador.mover(new Derecha(), escenario);
        jugador.mover(new Derecha(), escenario);
        jugador.mover(new Derecha(), escenario);

        assertEquals(jugador.puntaje(), 5);
    }



}
