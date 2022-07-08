package edu.fiuba.algo3.view.scenes.Contenedores;

import edu.fiuba.algo3.controller.BotonesMenus.BotonAtrasEventHandler;
import edu.fiuba.algo3.model.General.GPSChallenge;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContenedorRanking extends VBox {

    public ContenedorRanking(Stage stage, Scene escenaAnterior, GPSChallenge juego) {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);
        this.setPadding(new Insets(50));
        this.setStyle("-fx-background-color: #333333;");

        Label ranking = new Label();
        ranking.setText("TOP 10 JUGADORES");
        ranking.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 78));
        ranking.setStyle(
                "-fx-padding: 10;" +
                "-fx-background-radius: 5;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #88AABF;"+
                 "-fx-alignment: center");

        String[] top10 = juego.obtenerTop10();

        Label columnaRank = new Label();
        columnaRank.setText("RANK\n\n1\n2\n3\n4\n5\n6\n7\n8\n9\n10");
        columnaRank.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));
        columnaRank.setStyle(
                "-fx-padding: 10;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #F0F2F2;"+
                "-fx-alignment: center");

        Label columnaJugadores = new Label();
        columnaJugadores.setText("JUGADOR\n\n" + top10[0].split(";")[0] + "\n" + top10[1].split(";")[0] + "\n" + top10[2].split(";")[0] +
                "\n" + top10[3].split(";")[0] + "\n" + top10[4].split(";")[0] + "\n" + top10[5].split(";")[0] + "\n" + top10[6].split(";")[0] +
                "\n" + top10[7].split(";")[0] + "\n" + top10[8].split(";")[0] + "\n" + top10[9].split(";")[0]);
        columnaJugadores.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));
        columnaJugadores.setStyle(
                "-fx-padding: 10;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #F0F2F2;"+
                "-fx-alignment: center");

        Label columnaPuntajes = new Label();
        columnaPuntajes.setText("PUNTAJE\n\n" + top10[0].split(";")[1] + "\n" + top10[1].split(";")[1] + "\n" + top10[2].split(";")[1] +
                "\n" + top10[3].split(";")[1] + "\n" + top10[4].split(";")[1] + "\n" + top10[5].split(";")[1] + "\n" + top10[6].split(";")[1] +
                "\n" + top10[7].split(";")[1] + "\n" + top10[8].split(";")[1] + "\n" + top10[9].split(";")[1]);
        columnaPuntajes.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 28));
        columnaPuntajes.setStyle(
                "-fx-padding: 10;" +
                "-fx-text-fill: #010B40;" +
                "-fx-background-color: #F0F2F2;"+
                "-fx-alignment: center");

        HBox columnas = new HBox(columnaRank, columnaJugadores, columnaPuntajes);
        columnas.setSpacing(2);
        columnas.setAlignment(Pos.CENTER);

        Button botonAtras = new Button();
        botonAtras.setText("Atrás");
        botonAtras.setFont(Font.loadFont("file:src/main/java/edu/fiuba/algo3/view/resources/fonts/main.ttf", 36));
        botonAtras.setPrefSize(300,100);
        botonAtras.setStyle("-fx-background-color: #BDD9F2;" + "-fx-text-fill: #010B40;" + "-fx-background-radius: 10;");
        botonAtras.setOnAction(new BotonAtrasEventHandler(stage, escenaAnterior));

        this.getChildren().addAll(ranking, columnas, botonAtras);
    }

}
