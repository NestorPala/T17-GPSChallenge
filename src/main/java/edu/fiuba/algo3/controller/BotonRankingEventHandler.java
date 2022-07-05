package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.model.General.GPSChallenge;
import edu.fiuba.algo3.view.ContenedorOpciones;
import edu.fiuba.algo3.view.ContenedorRanking;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;

public class BotonRankingEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    GPSChallenge juego;

    private final static MediaPlayer sonidoRanking = new MediaPlayer(new Media(new File("src/main/java/edu/fiuba/algo3/view/sonidos/sonidoSeleccionar.mp3").toURI().toString()));

    public BotonRankingEventHandler(Stage stage, GPSChallenge juego) {
        this.stage = stage;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonidoRanking.play();
        sonidoRanking.seek(sonidoRanking.getStartTime());
        ContenedorRanking contenedorRanking = new ContenedorRanking(stage, stage.getScene(), juego);
        int resAncho = (int) Screen.getPrimary().getBounds().getWidth();
        int resAlto = (int) Screen.getPrimary().getBounds().getHeight();
        Scene escenaRanking = new Scene(contenedorRanking, resAncho,resAlto);
        this.stage.setScene(escenaRanking);
    }
}
