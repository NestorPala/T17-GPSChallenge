package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.General.Direccion;
import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.view.ContenedorEscenario;
import edu.fiuba.algo3.view.VistaJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonAbajoEventHandler implements EventHandler<ActionEvent> {

    private final VistaJugador vistaJugador;
    private final GPSChallenge juego;

    private final ContenedorEscenario contenedor;

    private final static MediaPlayer sonidoAuto = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoAuto.mp3").toURI().toString()));

    public BotonAbajoEventHandler(VistaJugador vistaJugador, GPSChallenge juego, ContenedorEscenario contenedor) {
        this.vistaJugador = vistaJugador;
        this.juego = juego;
        this.contenedor = contenedor;
        sonidoAuto.setVolume(0.2);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        juego.mover(Direccion.abajo());
        vistaJugador.actualizar();
        contenedor.updateEstado(juego.jugadorActual());
        sonidoAuto.play();
        sonidoAuto.seek(sonidoAuto.getStartTime());
    }
}
