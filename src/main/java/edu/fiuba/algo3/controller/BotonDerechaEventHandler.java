package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.Direccion;
import edu.fiuba.algo3.model.GPSChallenge;
import edu.fiuba.algo3.view.ContenedorEscenario;
import edu.fiuba.algo3.view.VistaJugador2;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonDerechaEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador2 vistaJugador;
    private final GPSChallenge juego;

    private final ContenedorEscenario contenedor;

    private final static MediaPlayer sonidoAuto = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidoAuto.mp3").toURI().toString()));

    public BotonDerechaEventHandler(VistaJugador2 vistaJugador, GPSChallenge juego, ContenedorEscenario contenedor) {
        this.vistaJugador = vistaJugador;
        this.juego = juego;
        this.contenedor = contenedor;
        sonidoAuto.setVolume(0.2);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.mover(Direccion.derecha());
        vistaJugador.actualizar();
        contenedor.setPuntaje(juego.jugadorActual());
        sonidoAuto.play();
        sonidoAuto.seek(sonidoAuto.getStartTime());
    }
}
