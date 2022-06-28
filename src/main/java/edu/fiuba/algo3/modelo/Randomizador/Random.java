package edu.fiuba.algo3.modelo.Randomizador;

public class Random implements Randomizer{
    public boolean random(double probabilidad){
        return Math.random() >= probabilidad;
    }
}
