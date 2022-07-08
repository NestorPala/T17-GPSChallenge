package edu.fiuba.algo3.controller.BotonesMenus;

import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.view.ContenedorJugadores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class BotonSeleccionarEventHandler implements EventHandler<ActionEvent> {
    final Stage stage;
    private final int tamañoDelJuego;
    private final static MediaPlayer sonidoClickear = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/resources/sounds/sonidoClickear.mp3").toURI().toString()));

    public BotonSeleccionarEventHandler(Stage stage, int tamañoDelJuego) {
        this.stage = stage;
        this.tamañoDelJuego = tamañoDelJuego;

    }
    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoClickear.play();
        sonidoClickear.seek(sonidoClickear.getStartTime());
        GPSChallenge juego = new GPSChallenge(tamañoDelJuego, tamañoDelJuego);
        ContenedorJugadores contenedorJugadores = new ContenedorJugadores(stage, juego);
        int resAncho = (int) Screen.getPrimary().getBounds().getWidth();
        int resAlto = (int) Screen.getPrimary().getBounds().getHeight();
        Scene escenaJugadores = new Scene(contenedorJugadores, resAncho, resAlto);
        this.stage.setScene(escenaJugadores);
    }
}
