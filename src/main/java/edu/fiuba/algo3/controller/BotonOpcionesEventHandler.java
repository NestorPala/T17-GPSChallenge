package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.ContenedorOpciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class BotonOpcionesEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    private final static MediaPlayer sonidoOpciones = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoSeleccionar.mp3").toURI().toString()));

    public BotonOpcionesEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoOpciones.play();
        sonidoOpciones.seek(sonidoOpciones.getStartTime());
        ContenedorOpciones contenedorOpciones = new ContenedorOpciones(stage, stage.getScene());
        Scene escenaOpciones = new Scene(contenedorOpciones, 960,540);
        this.stage.setScene(escenaOpciones);
    }
}
