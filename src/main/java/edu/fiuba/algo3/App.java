package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        StackPane layout = new StackPane();
        var scene = new Scene(layout, 640, 480);

        Button boton = new Button();
        boton.setText("Jugar");
        boton.setOnAction(e -> {
            System.out.println("Comienza el juego");
        });

        layout.getChildren().add(boton);


        stage.setTitle("GPS Challenge");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}