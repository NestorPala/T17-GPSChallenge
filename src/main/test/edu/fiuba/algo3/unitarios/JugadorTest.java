package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {




    // @Test
    // public void unJugadorInicializaCorrectamente() {
    //     Posicion posicionInicial = new Posicion(1, 1);
    //     IVehiculo vehiculoInicial = new Moto();
    //     Jugador jugador = new Jugador(posicionInicial, vehiculoInicial);

    //     assertEquals(jugador.puntaje(), 0);
    // }




    @Test
    public void aplicarUnMovimientoAlJugadorCambiaSuPosicion()
    {
        Posicion posicionInicial = new Posicion();
        Vehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(posicionInicial, vehiculoInicial);
        Escenario escenario = new Escenario(10, 10);

        jugador.mover(Direccion.derecha(), escenario);

        //assertEquals(jugador.posicion(), new Posicion(0, 1));
        assertEquals(new Posicion(1, 0), jugador.posicion());
    }



    // Esta prueba en particular no deberia lanzar excepciones
    @Test
    public void moverAlJugadorHaciaUnaPosicionInvalidaNoHaceNada()
    {
        Posicion posicionInicial = new Posicion();
        Vehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(posicionInicial, vehiculoInicial);
        //Escenario escenario = new Escenario(10, 10);
        Escenario escenario = new Escenario(0, 0);

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(posicionInicial, jugador.posicion());
    }



    
    @Test
    public void noSePuedeCrearUnJugadorConPosicionInicialInvalida()
    {

    }




    @Test
    public void noSePuedeCrearUnJugadorConUnVehiculoInicialInvalido()
    {

    }




    @Test
    public void laPuntuacionInicialDelJugadorEsCeroPuntos()
    {

    }




    @Test
    public void alPasarPorUnaCuadraSinObstaculosLaCantidadDePuntosEsCorrecta()
    {

    }




    @Test
    public void alPasarPorUnaCuadraConObstaculosLaCantidadDePuntosEsCorrecta()
    {

    }




    @Test
    public void alPasarDeVueltaPorElMismoObstaculoLaCantidadDePuntosEsCorrecta()
    {

    }




    @Test
    public void alPasarDeVueltaPorLaMismaSorpresaLaCantidadDePuntosEsCorrecta()
    {

    }




    @Test
    public void cuandoElJugadorLlegaALaMetaLaCantidadDePuntosEsCorrecta()
    {

    }
}
