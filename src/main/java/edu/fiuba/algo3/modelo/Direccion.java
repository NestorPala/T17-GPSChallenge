package edu.fiuba.algo3.modelo;

public class Direccion {
    private final int dirX;
    private final int dirY;

    private static final Logger logger = Logger.getInstance();

    public Direccion(int dirHorizontal, int dirVertical) {
        this.dirX = dirHorizontal;
        this.dirY = dirVertical;
    }

    public static Direccion arriba() {
        logger.log("El jugador se movio hacia arriba");
        return new Direccion(0, 1);
    }

    public static Direccion abajo() {
        logger.log("El jugador se movió hacia abajo");
        return new Direccion(0, -1);
    }

    public static Direccion izquierda() {
        logger.log("El jugador se movió hacia la izquierda");
        return new Direccion(-1, 0);
    }

    public static Direccion derecha() {
        logger.log("El jugador se movió hacia la derecha");
        return new Direccion(1, 0);
    }

    public Posicion calcularNuevaPosicion(Posicion unaPosicion) {
        Posicion nuevaPosicion = new Posicion(unaPosicion.x(), unaPosicion.y());
        nuevaPosicion.sumarX(this.dirX);
        nuevaPosicion.sumarY(this.dirY);
        return nuevaPosicion;
    }
}
