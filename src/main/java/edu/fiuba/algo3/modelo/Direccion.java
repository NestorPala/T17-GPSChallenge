package edu.fiuba.algo3.modelo;

public class Direccion {
    private final int dirX;
    private final int dirY;

    public Direccion(int dirHorizontal, int dirVertical) {
        this.dirX = dirHorizontal;
        this.dirY = dirVertical;
    }

    public static Direccion derecha(){
        return new Direccion(1,0);
    }

    public static Direccion izquierda(){
        return new Direccion(-1,0);
    }

    public static Direccion arriba(){
        return new Direccion(0,1);
    }

    public static Direccion abajo(){
        return new Direccion(0,-1);
    }

    public Posicion calcularNuevaPosicion(Posicion unaPosicion) {
        unaPosicion.sumarX(this.dirX);
        unaPosicion.sumarY(this.dirY);
        return unaPosicion;
    }
}
