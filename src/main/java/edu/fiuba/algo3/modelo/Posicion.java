package edu.fiuba.algo3.modelo;

public class Posicion {
    private int x;
    private int y;

    public Posicion(){
        this.x = 0;
        this.y = 0;
    }

    public Posicion(int valorX, int valorY){
        this.x = valorX;
        this.y = valorY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posicion posicion = (Posicion) o;

        if (x != posicion.x) return false;
        return y == posicion.y;
    }

    public int obtenerX(){
        return x;
    }

    public int obtenerY(){
        return y;
    }

    public void moverseDesdePosicionInicial(Movimiento movimiento){
        this.x = x + movimiento.obtenerX();
        this.y = y + movimiento.obtenerY();
    }
}
