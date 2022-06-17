package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasosTest {




    @Test
    public void test01_motoChocaPozoYEsPenalizadaConTresMovimientos()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(4, jugador.puntaje());
    }

    

    
    @Test
    public void test02_autoChocaPozoYEsPenalizadoConTresMovimientos()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo auto = new Auto();
        Jugador jugador = new Jugador(auto);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(4, jugador.puntaje());
    }




    @Test
    public void test03_todoterrenoChocaPozoYNoEsPenalizado()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(todoterreno);
        Chocable pozo = new Pozo();

        escenario.insertarChocable(pozo, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(1, jugador.puntaje());
    }




    @Test
    public void test04_motoChocaConPiqueteYEsPenalizadoConDosMovimientos()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable piquete = new Piquete();

        escenario.insertarChocable(piquete, new Posicion(2, 1));

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(3, jugador.puntaje());
    }




    @Test
    public void test05_todoterrenoChocaConTresPozosYEsPenalizadoConDosMovimientos()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(todoterreno);
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
    public void test06_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable sorpresaFavorable = new SorpresaFavorable();

        escenario.insertarChocable(sorpresaFavorable, new Posicion(0, 1));

        jugador.mover(Direccion.izquierda(), escenario);

        assertEquals(0.8, jugador.puntaje());
    }




    @Test
    public void test07_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable sorpresaDesfavorable = new SorpresaDesfavorable();

        escenario.insertarChocable(sorpresaDesfavorable, new Posicion(1, 2));

        jugador.mover(Direccion.arriba(), escenario);

        assertEquals(1.25, jugador.puntaje());
    }


    @Test
    public void test08_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() 
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo auto = new Auto();
        Jugador jugador = new Jugador(auto);
        Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Chocable pozo = new Pozo();

        escenario.insertarChocable(sorpresaCambioVehiculo, new Posicion(1, 0));
        escenario.insertarChocable(pozo, new Posicion(0, 0));

        jugador.mover(Direccion.abajo(), escenario);
        jugador.mover(Direccion.izquierda(), escenario);

        assertEquals(2, jugador.puntaje());
    }



    @Test
    public void test09_UnVehiculoSeEncuentraConUnControlPolicialYPuedeRecibirPenalizacion()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable controlPolicial = new ControlPolicial();

        escenario.insertarChocable(controlPolicial, new Posicion(1, 2));

        jugador.mover(Direccion.arriba(), escenario);

        assertTrue((jugador.puntaje() == 1.0 || jugador.puntaje() == 4.0));
    }



    // Idea: considerar sorpresa y obstaculo a la vez
    @Test
    public void test10_UnTodoterrenoChocaConUnaSorpresaCambioDeVehiculoYLuegoChocaConUnPiquete()
    {
        Escenario escenario = Escenario.getInstance(25, 25);
        Vehiculo todoterreno = new Todoterreno();
        Jugador jugador = new Jugador(todoterreno);
        Chocable sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Chocable piquete = new Piquete();

        escenario.insertarChocable(sorpresaCambioVehiculo, new Posicion(1, 2));
        escenario.insertarChocable(piquete, new Posicion(1, 3));

        jugador.mover(Direccion.arriba(), escenario);
        jugador.mover(Direccion.arriba(), escenario);

        assertEquals(4, jugador.puntaje());
    }



    
}
