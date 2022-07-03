package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorOpciones extends VBox {

    public ContenedorOpciones(Stage stage, Scene escenaAnterior) {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));

        Label texto = new Label();
        texto.setText("OPCIONES");
        texto.setFont(Font.font("Trebuchet MS", 100));

        Button botonAtras = new Button();
        botonAtras.setText("Atras");
        botonAtras.setFont(Font.font("Trebuchet MS", 50));
        botonAtras.setPrefSize(300,100);
        botonAtras.setOnAction(new BotonAtrasEventHandler(stage, escenaAnterior));

        this.getChildren().addAll(texto, botonAtras);
    }

}
