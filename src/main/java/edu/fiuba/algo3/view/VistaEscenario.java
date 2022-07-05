package edu.fiuba.algo3.view;


import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.Posicion;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class VistaEscenario extends Group {

    public double ancho;
    public double alto;
    private double tileAncho = 36;
    private double tileAlto = 36;

    private GridPane tabla;

    private final Pane[][] panes;

    public VistaEscenario(int altoEscenario, int anchoEscenario) {
        tabla = new GridPane();
        ancho = anchoEscenario;
        alto = altoEscenario;
        panes = new Pane[anchoEscenario][altoEscenario];
        Escenario escenario = Escenario.getInstance();
        Imagenes imagenes = new Imagenes();

        for (int i = 0; i < anchoEscenario; i++) {
            for (int j = 0; j < altoEscenario; j++) {
                StackPane v = new StackPane();
                v.setMinHeight(this.tileAlto);
                v.setMinWidth(this.tileAncho);
                v.setBackground(new Background(new BackgroundFill(Color.rgb(227,227,227), new CornerRadii(2.5), new Insets(-1))));
                v.getChildren().add(0, imagenes.devolverImagenes(escenario.obtenerChocable(new Posicion(i,j))));
                v.setPadding(new Insets(2));
                panes[i][j] = v;
                tabla.add(v, i, j);
            }
        }

        tabla.setVgap(10);
        tabla.setHgap(10);
        tabla.setBackground(new Background(new BackgroundFill(Color.rgb(167, 189, 217), new CornerRadii(2.5), new Insets(5))));
        tabla.setBorder(new Border(new BorderStroke(Color.rgb(167, 189, 217), BorderStrokeStyle.SOLID, new CornerRadii(2.5), new BorderWidths(20))));

        //Shape shape = Path.subtract(new Rectangle(ancho * 1.5, alto * 1.5), new Circle(10 * 100 + 50, 10 * 100 + 50, 50));
        //shape = Path.subtract(shape, new Circle(2 * 100, 2 * 100, 100));

        this.addView(tabla);
        //this.addView(shape);
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
                    panes[i][j].setBorder(new Border(new BorderStroke(Color.rgb(227,227,227), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
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

