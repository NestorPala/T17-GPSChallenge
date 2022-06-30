package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Escenario;
import edu.fiuba.algo3.modelo.Posicion;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


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
        Escenario escenario = Escenario.getInstance();
        Imagenes imagenes = new Imagenes();

        for (int i = 0; i < anchoEscenario; i++) {
            for (int j = 0; j < altoEscenario; j++) {
                Pane v = new Pane();
                v.setMinHeight(this.tileAlto);
                v.setMinWidth(this.tileAncho);
                v.setBackground(new Background(new BackgroundFill(Color.rgb(140,140,140), new CornerRadii(2.5), new Insets(-1))));
                v.getChildren().add(0, imagenes.devolverImagenes(escenario.obtenerChocable(new Posicion(i,j))));
                panes[i][j] = v;
                tabla.add(v , i, j);
            }
        }

        tabla.setVgap(5);
        tabla.setHgap(5);

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

        panes[x][y].getChildren().add(1, view);
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}

