package edu.fiuba.algo3.interfazGrafica;


import edu.fiuba.algo3.modelo.Jugador.Jugador;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class VistaJugador2{

    private double escalaJugador = 1;
    private final VistaEscenario vistaEscenario;
    ImageView imagenJugador;
    private final Jugador jugador;
    private int ultimaPosicionX;


    public VistaJugador2(VistaEscenario escenario, Jugador jugador) {

        this.vistaEscenario = escenario;
        this.jugador = jugador;
        this.ultimaPosicionX = jugador.posicion().x();

        imagenJugador = new ImageView();
        imagenJugador.setScaleX(escalaJugador);
        imagenJugador.setScaleY(escalaJugador);
        imagenJugador.setFitHeight(32);
        imagenJugador.setFitWidth(32);

        imagenJugador.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/coche.png").toURI().toString()));
        escenario.addViewOnMap(imagenJugador, jugador.posicion().x(), jugador.posicion().y());

        dibujar();
    }

    public void dibujar() {

        imagenJugador.setTranslateX(0);
        imagenJugador.setTranslateY(0);
        vistaEscenario.updateView(imagenJugador);
    }

    public void actualizar() {

        int actualX = jugador.posicion().x();
        int actualY = jugador.posicion().y();
        if (ultimaPosicionX > actualX) {
            this.imagenJugador.setScaleX( -
                    Math.abs(imagenJugador.getScaleX()));
        }

        else if (ultimaPosicionX < actualX) {
            this.imagenJugador.setScaleX(
                    Math.abs(imagenJugador.getScaleX()));
        }

        this.ultimaPosicionX = jugador.posicion().x();
        vistaEscenario.addViewOnMap(this.imagenJugador, actualX, actualY);
    }

}

