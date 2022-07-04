package edu.fiuba.algo3.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;

import edu.fiuba.algo3.controller.BotonJugarEventHandler;
import edu.fiuba.algo3.controller.BotonOpcionesEventHandler;
import edu.fiuba.algo3.controller.BotonSalirEventHandler;

public class ContenedorInicio extends VBox {

    Stage stage;

    public ContenedorInicio(Stage stage, Scene proximaEscena) {

        super();

        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));

        BackgroundImage fondoPantalla= new BackgroundImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/fondoPantalla.gif").toURI().toString(),2000,1334,false,true),
        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        this.setBackground(new Background(fondoPantalla));

        Button botonJugar = new Button();
        botonJugar.setText("Jugar");
        botonJugar.setFont(Font.font("SansSerif", 50));
        botonJugar.setPrefSize(300,100);
        botonJugar.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;");

        System.out.println(Font.getFontNames());

        Button botonOpciones = new Button();
        botonOpciones.setText("Opciones");
        botonOpciones.setFont(Font.font("SansSerif", 50));
        botonOpciones.setPrefSize(300,100);
        botonOpciones.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;");

        Button botonSalir = new Button();
        botonSalir.setText("Salir");
        botonSalir.setFont(Font.font("SansSerif", 50));
        botonSalir.setPrefSize(300,100);
        botonSalir.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;");

        Label texto = new Label();
        texto.setText("GPS CHALLENGE");
        texto.setFont(Font.font("Trebuchet MS", 100));
        texto.setStyle(
                "-fx-padding: 10;" +
                "-fx-background-radius: 5;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                "-fx-alignment: center");

        botonJugar.setOnAction(new BotonJugarEventHandler(stage, proximaEscena));
        botonOpciones.setOnAction(new BotonOpcionesEventHandler(stage));
        botonSalir.setOnAction(new BotonSalirEventHandler());

        stage.getIcons().add(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/gps.png").toURI().toString()));

        this.getChildren().addAll(texto, botonJugar, botonOpciones, botonSalir);
    }

}
