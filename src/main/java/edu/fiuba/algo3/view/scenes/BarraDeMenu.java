package edu.fiuba.algo3.view.scenes;

import edu.fiuba.algo3.controller.BotonesMenus.BotonSalirEventHandler;
import edu.fiuba.algo3.controller.OpcionesMenus.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.controller.OpcionesMenus.OpcionInstruccionesEventHandler;
import edu.fiuba.algo3.controller.OpcionesMenus.OpcionPantallaCompletaEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    final MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage){

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionInstrucciones = new MenuItem("Instrucciones");

        BotonSalirEventHandler opcionSalirEventHandler = new BotonSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirEventHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeEventHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeEventHandler);

        OpcionInstruccionesEventHandler opcionInstruccionesEventHandler = new OpcionInstruccionesEventHandler();
        opcionInstrucciones.setOnAction(opcionInstruccionesEventHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaEventHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaEventHandler);

        opcionPantallaCompleta.setDisable(false);

        menuArchivo.getItems().addAll(opcionSalir);
        menuVer.getItems().addAll(opcionPantallaCompleta);
        menuAyuda.getItems().addAll(opcionInstrucciones, opcionAcercaDe);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }
}
