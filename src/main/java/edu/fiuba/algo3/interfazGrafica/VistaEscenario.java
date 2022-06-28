package edu.fiuba.algo3.interfazGrafica;


import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.io.File;

public class VistaEscenario extends Group {

    public double ancho;
    public double alto;
    private double tileAncho = 32;
    private double tileAlto = 32;

    private GridPane tabla;

    private final Pane[][] panes;

    public VistaEscenario(int altoEscenario, int anchoEscenario) {
        tabla = new GridPane();
        ancho = tileAncho * anchoEscenario;
        alto = tileAlto * altoEscenario;
        panes = new Pane[(int) ancho][(int) alto];

        for (int i = 0; i < anchoEscenario; i++) {
            for (int j = 0; j < altoEscenario; j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileAlto);
                v.setMinWidth(this.tileAncho);
                panes[i][j] = v;
                tabla.add(v , i, j);
            }
        }
        Background bi = new Background(new BackgroundImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/fondoGris.jpg").toURI().toString()),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(this.ancho, this.alto, false, false, false, false)));
        tabla.setBackground(bi);

        this.addView(tabla);
    }

    public void addViewOnMap(Node view, int x, int y) {
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
        panes[x][y].getChildren().add(0, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }

    public void updateView(Node view) {
        getChildren().remove(view);
        getChildren().add(view);
    }
}

