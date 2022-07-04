package edu.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Trabajo practico de algoritmos y programacion III");
        alert.setContentText("Integrantes: \n\nMatias Vallejos\nAlejo Fabregas\nNestor Palavecino\nLorenzo Ahumada");
        alert.show();
    }
}
