package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JugadorTest {




    @Test
    public void aplicarUnMovimientoAlJugadorCambiaSuPosicion()
    {
        Vehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(vehiculoInicial);
        Escenario escenario = Escenario.getInstance(10, 10);

        jugador.mover(Direccion.derecha(), escenario);

        assertEquals(new Posicion(2, 1), jugador.posicion());
    }



    
    @Test
    public void moverAlJugadorHaciaUnaPosicionInvalidaNoHaceNada()
    {
        Posicion posicionInicial = new Posicion(2,1);
        Vehiculo vehiculoInicial = new Moto();
        Jugador jugador = new Jugador(vehiculoInicial);
        //Escenario escenario = Escenario.getInstance(10, 10);
        Escenario escenario = Escenario.getInstance(0, 0);

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
