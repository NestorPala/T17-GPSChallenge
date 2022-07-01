package edu.fiuba.algo3.unitarios;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Direccion;
import edu.fiuba.algo3.model.Logger;
import edu.fiuba.algo3.model.Jugador.Jugador;
import edu.fiuba.algo3.model.Vehiculos.Moto;

public class LoggerTest {
    @Test
    public void sePuedeLoggearCorrectamente(){
        Logger logger = Logger.getInstance();
        logger.activar();

        Jugador jugador = new Jugador(new Moto(), "Jorge");
        jugador.mover(Direccion.derecha());

        logger.desactivar();
        
        jugador.mover(Direccion.abajo());
    }
}
