package edu.fiuba.algo3.interfazGrafica.Manejadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonOpcionesEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;

    public BotonOpcionesEventHandler(Stage stage, Scene proximaEscena){
        this.proximaEscena = proximaEscena;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {this.stage.setScene(this.proximaEscena);}
}
