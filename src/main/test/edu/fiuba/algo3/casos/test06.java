package edu.fiuba.algo3.casos;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test06 {
    @Test
    public void test06_UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable()
    {
        Escenario escenario = Escenario.getInstance(20, 20);
        Vehiculo moto = new Moto();
        Jugador jugador = new Jugador(moto);
        Chocable sorpresaFavorable = new SorpresaFavorable();

        escenario.insertarChocable(sorpresaFavorable, new Posicion(0, 1));

        jugador.mover(Direccion.izquierda());

        assertEquals(0.8, jugador.puntaje());
    }
}
