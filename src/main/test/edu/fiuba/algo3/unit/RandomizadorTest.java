package edu.fiuba.algo3.unit;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.model.Randomizador.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RandomizadorTest {

    @Test
    public void elTestDaValoresCorrectos(){
        Random randomizador = new Random();

        assertFalse(randomizador.random(2));
        assertTrue(randomizador.random(0));
    }
}
