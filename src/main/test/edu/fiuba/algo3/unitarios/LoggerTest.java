package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Direccion;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Logger;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import org.junit.jupiter.api.Test;

public class LoggerTest {
    @Test
    public void sePuedeLoggearCorrectamente(){
        Logger logger = Logger.getInstance();
        logger.activar();

        Jugador jugador = new Jugador(new Moto(), "Jorge");
        jugador.mover(Direccion.derecha());
    }
}
