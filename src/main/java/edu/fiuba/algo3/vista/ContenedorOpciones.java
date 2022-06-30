package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.vista.Manejadores.BotonAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorOpciones extends VBox {

    Scene escenaAnterior;
    Stage stage;

    public ContenedorOpciones(Stage stage, Scene escenaAnterior){

        super();

        this.stage = stage;
        this.escenaAnterior = escenaAnterior;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label texto = new Label();
        texto.setText("OPCIONES");
        texto.setFont(Font.font("Times New Roman", 100));

        Button botonAtras = new Button();
        botonAtras.setText("Atras");
        botonAtras.setFont(Font.font("Times New Roman", 50));
        botonAtras.setPrefSize(300,100);

        BotonAtrasEventHandler botonAtrasEventHandler = new BotonAtrasEventHandler(stage, escenaAnterior);
        botonAtras.setOnAction(botonAtrasEventHandler);

        this.getChildren().addAll(texto, botonAtras);
    };

}
