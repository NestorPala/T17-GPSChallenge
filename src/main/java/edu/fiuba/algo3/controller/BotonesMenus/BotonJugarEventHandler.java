package edu.fiuba.algo3.controller.BotonesMenus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonJugarEventHandler implements EventHandler<ActionEvent> {

    final Stage stage;
    final Scene proximaEscena;

    private final static MediaPlayer sonidoClickear = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoClickear.mp3").toURI().toString()));

    public BotonJugarEventHandler(Stage stage, Scene proximaEscena) {
        this.proximaEscena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoClickear.play();
        sonidoClickear.seek(sonidoClickear.getStartTime());
        this.stage.setScene(this.proximaEscena);
    }
}
