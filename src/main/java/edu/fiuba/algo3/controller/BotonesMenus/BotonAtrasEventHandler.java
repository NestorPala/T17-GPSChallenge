package edu.fiuba.algo3.controller.BotonesMenus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonAtrasEventHandler implements EventHandler<ActionEvent> {

    final Stage stage;
    final Scene escenaAnterior;

    private final static MediaPlayer sonidoAtras = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/resources/sounds/sonidoAtras.mp3").toURI().toString()));

    public BotonAtrasEventHandler(Stage stage, Scene escenaAnterior) {
        this.escenaAnterior = escenaAnterior;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoAtras.play();
        sonidoAtras.seek(sonidoAtras.getStartTime());
        this.stage.setScene(this.escenaAnterior);
    }
}
