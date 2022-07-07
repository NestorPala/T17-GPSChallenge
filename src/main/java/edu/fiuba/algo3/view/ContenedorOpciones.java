package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.BotonAtrasEventHandler;
import edu.fiuba.algo3.controller.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.controller.OpcionInstruccionesEventHandler;
import edu.fiuba.algo3.controller.OpcionPantallaCompletaEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorOpciones extends VBox {

    final MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");
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

        Button botonPantallaCompleta = new Button();
        botonPantallaCompleta.setText("Pantalla Completa");
        botonPantallaCompleta.setFont(Font.font("SansSerif", 28));
        botonPantallaCompleta.setPrefSize(300,100);
        botonPantallaCompleta.setStyle("-fx-background-color: #F0F2F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonPantallaCompleta.setOnAction(new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta));

        opcionPantallaCompleta.setDisable(false);

        Button botonInstrucciones = new Button();
        botonInstrucciones.setText("Instrucciones");
        botonInstrucciones.setFont(Font.font("SansSerif", 28));
        botonInstrucciones.setPrefSize(300,100);
        botonInstrucciones.setStyle("-fx-background-color: #F0F2F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonInstrucciones.setOnAction(new OpcionInstruccionesEventHandler());

        Button botonAcercaDe = new Button();
        botonAcercaDe.setText("Acerca de");
        botonAcercaDe.setFont(Font.font("SansSerif", 28));
        botonAcercaDe.setPrefSize(300,100);
        botonAcercaDe.setStyle("-fx-background-color: #F0F2F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonAcercaDe.setOnAction(new OpcionAcercaDeEventHandler());

        Button botonAtras = new Button();
        botonAtras.setText("Atrás");
        botonAtras.setFont(Font.font("SansSerif", 36));
        botonAtras.setPrefSize(300,100);
        botonAtras.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonAtras.setOnAction(new BotonAtrasEventHandler(stage, escenaAnterior));

        this.getChildren().addAll(textoOpciones, botonPantallaCompleta, botonInstrucciones, botonAcercaDe, botonAtras);
    }

}
