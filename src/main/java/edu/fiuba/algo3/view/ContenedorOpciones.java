package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAtrasEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorOpciones extends VBox {

    Stage stage;
    public ContenedorOpciones(Stage stage, Scene escenaAnterior) {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: #333333;");

        Label textoOpciones = new Label();
        textoOpciones.setText("OPCIONES");
        textoOpciones.setFont(Font.font("Trebuchet MS", 78));
        textoOpciones.setStyle(
                "-fx-padding: 10;" +
                        "-fx-background-radius: 5;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #010B40;" +
                        "-fx-background-color: #88AABF;"+
                        "-fx-alignment: center");

        Button botonAtras = new Button();
        botonAtras.setText("Atrás");
        botonAtras.setFont(Font.font("SansSerif", 36));
        botonAtras.setPrefSize(300,100);
        botonAtras.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonAtras.setOnAction(new BotonAtrasEventHandler(stage, escenaAnterior));

        this.getChildren().addAll(textoOpciones, botonAtras);
    }

}
