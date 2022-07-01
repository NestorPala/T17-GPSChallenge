package edu.fiuba.algo3.view;


import edu.fiuba.algo3.model.Escenario;
import edu.fiuba.algo3.model.Posicion;
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
                v.setBackground(new Background(new BackgroundFill(Color.rgb(180,180,180), new CornerRadii(2.5), new Insets(-1))));
                v.getChildren().add(0, imagenes.devolverImagenes(escenario.obtenerChocable(new Posicion(i,j))));
                panes[i][j] = v;
                tabla.add(v , i, j);
            }
        }

        tabla.setVgap(10);
        tabla.setHgap(10);

        this.addView(tabla);
    }

    public void addViewOnMap(Node view, int x, int y) {
        this.limpiarEscenario(view);
        panes[x][y].getChildren().add(1, view);
        panes[x][y].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    public void limpiarEscenario(Node view){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                    panes[i][j].setBorder(null);
                } catch (Exception e) {
                    //TODO: handle exception
                }
            }
        }
    }

    public void addView(Node view) {
        this.getChildren().add(view);
    }
}
