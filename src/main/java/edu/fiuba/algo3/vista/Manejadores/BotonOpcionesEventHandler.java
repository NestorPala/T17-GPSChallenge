package edu.fiuba.algo3.vista.Manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonOpcionesEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    private final static MediaPlayer sonidoOpciones = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/vista/sonidoSeleccionar.mp3").toURI().toString()));

    public BotonOpcionesEventHandler(Stage stage, Scene proximaEscena) {
        this.proximaEscena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoOpciones.play();
        sonidoOpciones.seek(sonidoOpciones.getStartTime());
        this.stage.setScene(this.proximaEscena);
    }
}
