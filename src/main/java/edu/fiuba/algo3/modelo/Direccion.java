package edu.fiuba.algo3.modelo;

public class Direccion {
    private int dirX;
    private int dirY;

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

    public Direccion direccionOpuesta(Direccion unaDireccion) {
        unaDireccion.dirX *= -1;
        unaDireccion.dirY *= -1;
        return unaDireccion;
    }
}
