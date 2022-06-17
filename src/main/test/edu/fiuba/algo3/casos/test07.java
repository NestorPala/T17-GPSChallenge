package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test07 {
    @Test
    public void test07_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable sorpresaDesfavorable = new SorpresaDesfavorable();

        escenario.insertarChocable(sorpresaDesfavorable, new Posicion(1, 2));

        jugador.mover(Direccion.arriba());

        assertEquals(1.25, jugador.puntaje());
    }
}
