package edu.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionInstruccionesEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Instrucciones");
        alert.setHeaderText("Reglas del juego");
        alert.setContentText("El objetivo del juego es lograr que el vehículo llegue a la meta con la menor cantidad de movimientos posibles.\n\n" +
                "Cada movimiento realizado le sumará un punto al puntaje del jugador.\n\n" +
                "El escenario que debe atravesar el jugador está repleto de obstaculos que pueden aumentar o disminuir su puntaje.\n\n" +
                "Los obstaculos que puede encontrar el jugador son:\n\n" +
                "Pozo: Penaliza con 3 puntos a autos y motos, y con 2 puntos a todoterreno en el tercer pozo encontrado\n\n" +
                "Piquete: Impide el paso a autos y todoterreno, motos pueden pasar con 2 puntos de penalizacion\n\n" +
                "Control Policial: Tiene una probabilidad de penalizar con 3 puntos según el vehiculo, motos(80%), autos(50%), todoterreno(30%)\n\n" +
                "Sorpresa Favorable: Resta un 20% al puntaje\n\n" +
                "Sorpresa Desfavorable: Suma un 25% al puntaje\n\n" +
                "Sorpresa Cambio de Vehiculo: Cambia el vehiculo del jugador, moto a auto, auto a todoterreno y todoterreno a moto\n\n" +
                "El jugador que menor puntaje posea será el ganador de la partida.");
        alert.setWidth(400);
        alert.setHeight(700);
        alert.show();
    }
}
