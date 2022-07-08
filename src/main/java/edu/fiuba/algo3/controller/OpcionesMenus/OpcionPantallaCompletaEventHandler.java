package edu.fiuba.algo3.controller.OpcionesMenus;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {

    final Stage stage;
    final MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta){
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(!stage.isFullScreen()){
            stage.hide();
            stage.setFullScreen(true);
            stage.show();
        }
        else{
            stage.hide();
            stage.setFullScreen(false);
            stage.show();
        }
    }
}
