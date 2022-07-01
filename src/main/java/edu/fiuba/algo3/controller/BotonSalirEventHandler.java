package edu.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BotonSalirEventHandler implements EventHandler<ActionEvent> {

    private final static MediaPlayer sonidoSalir = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidoAtras.mp3").toURI().toString()));

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoSalir.play();
        sonidoSalir.seek(sonidoSalir.getStartTime());
        System.exit(0);
    }
}
