package edu.fiuba.algo3;

import edu.fiuba.algo3.view.ContenedorDificultad;
import edu.fiuba.algo3.view.ContenedorInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {


        stage.setTitle("GPS CHALLENGE");
        stage.setMaximized(true);

        int resAncho = (int) Screen.getPrimary().getBounds().getWidth();
        int resAlto = (int) Screen.getPrimary().getBounds().getHeight();

        ContenedorDificultad contenedorDificultad = new ContenedorDificultad(stage);
        Scene escenaDificultad = new Scene(contenedorDificultad, resAncho, resAlto);

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, escenaDificultad);
        Scene escenaInicial = new Scene(contenedorInicio, resAncho, resAlto);

        stage.setScene(escenaInicial);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}