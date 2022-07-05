package edu.fiuba.algo3.view;


import edu.fiuba.algo3.model.General.Escenario;
import edu.fiuba.algo3.model.General.Posicion;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


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

        this.addView(tabla);
    }

    public void addViewOnMap(Node view, int x, int y) {
        this.limpiarEscenario(view);
        panes[x][y].getChildren().add(1, view);
        panes[x][y].setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        panes[x][y].setVisible(true);
        this.mostrarArea(x,y);
        this.mostrarMeta();
    }

    public void mostrarArea(int x, int y){
        for (int i = 1; i < 2; i++){
            if(x+i < ancho && panes[x+i][y] != null){
                panes[x+i][y].setVisible(true);
            }
            if(y+i < alto && panes[x][y+i] != null){
                panes[x][y+i].setVisible(true);
            }
            if(x+i < ancho && y+i < alto && panes[x+i][y+i] != null){
                panes[x+i][y+i].setVisible(true);
            }
            if(x-i >= 0 && panes[x-i][y] != null){
                panes[x-i][y].setVisible(true);
            }
            if(y-i >= 0 && panes[x][y-i] != null){
                panes[x][y-i].setVisible(true);
            }
            if(x-i >= 0 && y-i >= 0 && panes[x-i][y-i] != null){
                panes[x-i][y-i].setVisible(true);
            }
            if(x+i < ancho && y-i >= 0 && panes[x+i][y-i] != null){
                panes[x+i][y-i].setVisible(true);
            }
            if(x-i >= 0 && y+i < alto && panes[x-i][y+i] != null){
                panes[x-i][y+i].setVisible(true);
            }
        }
    }

    public void mostrarMeta(){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                if(panes[i][j].getChildren().get(0).getId() == "Meta") {
                    panes[i][j].setVisible(true);
                }
            }
        }
    }

    public void limpiarEscenario(Node view){
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                try {
                    panes[i][j].getChildren().remove(view);
                    panes[i][j].setBorder(new Border(new BorderStroke(Color.rgb(227,227,227), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    panes[i][j].setVisible(false);
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

