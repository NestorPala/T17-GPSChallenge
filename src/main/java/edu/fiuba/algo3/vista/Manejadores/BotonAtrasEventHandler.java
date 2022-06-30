package edu.fiuba.algo3.vista.Manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonAtrasEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene escenaAnterior;

    public BotonAtrasEventHandler(Stage stage, Scene escenaAnterior){
        this.escenaAnterior = escenaAnterior;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {this.stage.setScene(this.escenaAnterior);}
}
