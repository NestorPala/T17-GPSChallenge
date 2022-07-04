package edu.fiuba.algo3.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("Trabajo practico Algoritmos III");
    }
}
