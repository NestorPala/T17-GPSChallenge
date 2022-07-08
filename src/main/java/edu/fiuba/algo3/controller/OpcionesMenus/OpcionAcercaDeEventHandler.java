package edu.fiuba.algo3.controller.OpcionesMenus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Trabajo Práctico de Algoritmos y Programación III");
        alert.setContentText("Integrantes: \n\nMatías Vallejos\nAlejo Fábregas\nNéstor Palavecino\nLorenzo Ahumada");
        alert.show();
    }
}
