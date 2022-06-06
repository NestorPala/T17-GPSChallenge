package edu.fiuba.algo3.modelo;

public class Movimiento {
    private int x;
    private int y;

    public Movimiento(){
        this.x = 0;
        this.y = 0;
    }

    public Movimiento(int movimientoEnX, int movimientoEnY){
        this.x = movimientoEnX;
        this.y = movimientoEnY;
    }

    public int obtenerX(){
        return x;
    }

    public int obtenerY(){
        return y;
    }
}
