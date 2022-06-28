package edu.fiuba.algo3.interfazGrafica;


import edu.fiuba.algo3.interfazGrafica.Manejadores.BotonJugarEventHandler;
import edu.fiuba.algo3.interfazGrafica.Manejadores.BotonSalirEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {

    Stage stage;

    public ContenedorInicio(Stage stage, Scene proximaEscena){

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");

        Button botonSalir = new Button();
        botonSalir.setText("Salir");

        Label texto = new Label();
        texto.setText("GPS CHALLENGE");
        texto.setFont(Font.font("Times New Roman", 50));

        BotonJugarEventHandler botonJugarEventHandler = new BotonJugarEventHandler(stage, proximaEscena);
        botonJugar.setOnAction(botonJugarEventHandler);

        BotonSalirEventHandler botonSalirEventHandler = new BotonSalirEventHandler();
        botonSalir.setOnAction(botonSalirEventHandler);

        this.getChildren().addAll(texto, botonJugar, botonSalir);
    }

}
