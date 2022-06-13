package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.Chocable;
import edu.fiuba.algo3.modelo.Chocables.Piquete;
import edu.fiuba.algo3.modelo.Chocables.Pozo;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Chocables.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Chocables.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasosTest {




    @Test
    public void test01_motoChocaPozoYEsPenalizadaConTresMovimientos() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        //jugador.mover(new Derecha(), escenario);
        //jugador.mover(new Direccion(), escenario);
        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(4, jugador.puntaje());
    }




    // IDEAS PARA IMPLEMENTAR POSICION

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
    public void test02_autoChocaPozoYEsPenalizadoConTresMovimientos() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo auto = new Auto();
        Jugador jugador = new Jugador(new Posicion(1, 1), auto);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(4, jugador.puntaje());
    }




    @Test
    public void test03_todoterrenoChocaPozoYNoEsPenalizado() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(new Posicion(1, 1), todoterreno);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(1, jugador.puntaje());
    }




    @Test
    public void test04_motoChocaConPiqueteYEsPenalizadoConDosMovimientos() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        Chocable piquete = new Piquete();

        escenario.insertarChocable(piquete, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(3, jugador.puntaje());
    }




    @Test
    public void test05_todoterrenoChocaConTresPozosYEsPenalizadoConDosMovimientos() 
    throws PosicionDelEscenarioInvalida 
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(new Posicion(1, 1), todoterreno);
        Chocable pozo = new Pozo();

        // Pongo los pozos
        escenario.insertarChocable(pozo, new Posicion(2, 1));
        escenario.insertarChocable(pozo, new Posicion(3, 1));
        escenario.insertarChocable(pozo, new Posicion(4, 1));

        // Muevo tres veces al jugador
        jugador.mover(Direccion.derecha(), escenario);
        jugador.mover(Direccion.derecha(), escenario);
        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(5, jugador.puntaje());
    }




    @Test
    public void test06_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable() throws PosicionDelEscenarioInvalida
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        Chocable sorpresaFavorable = new SorpresaFavorable();

        escenario.insertarChocable(sorpresaFavorable, new Posicion(0, 1));

        jugador.mover(Direccion.izquierda(), escenario);

        assertEquals(0.8, jugador.puntaje());
    }




    @Test
    public void test07_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable() throws PosicionDelEscenarioInvalida
    {
        Escenario escenario = new Escenario(20, 20);
        Vehiculo moto = new Auto();
        Jugador jugador = new Jugador(new Posicion(1, 1), moto);
        Chocable sorpresaDesfavorable = new SorpresaDesfavorable();

        escenario.insertarChocable(sorpresaDesfavorable, new Posicion(1, 2));

        jugador.mover(Direccion.arriba(), escenario);

        assertEquals(1.25, jugador.puntaje());
    }




    @Test
    public void test08_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() 
    {
    }




    // Idea: considerar sorpresa y obstaculo a la vez
    @Test
    public void test09_() 
    {
    }




    // Idea: considerar chocable con probabilidad
    @Test
    public void test10_() 
    {
    }



    
}
