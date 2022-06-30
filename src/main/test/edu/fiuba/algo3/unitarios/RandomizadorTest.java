package edu.fiuba.algo3.unitarios;

import edu.fiuba.algo3.modelo.Randomizador.Random;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizadorTest {

    @Test
    public void elTestDaValoresCorrectos(){
        Random randomizador = new Random();

        assertFalse(randomizador.random(2));
        assertTrue(randomizador.random(0));
    }
}
