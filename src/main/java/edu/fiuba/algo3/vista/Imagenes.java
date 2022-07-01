package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Chocables.*;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.Todoterreno;
import edu.fiuba.algo3.modelo.Vehiculos.Vehiculo;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Imagenes {

    public Imagenes() {}

    public ImageView devolverImagenes(Chocable chocable) {
        if (chocable instanceof ControlPolicial) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/police.png").toURI().toString()));
            imagen.setOpacity(0.5);
            return imagen;
        }
        if (chocable instanceof Pozo) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/pozo.png").toURI().toString()));
            imagen.setOpacity(0.5);
            return imagen;
        }
        if (chocable instanceof Piquete) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/manifestation.png").toURI().toString()));
            imagen.setOpacity(0.5);
            return imagen;
        }
        if (chocable instanceof SorpresaFavorable) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/gift.png").toURI().toString()));
            imagen.setOpacity(0.5);
            return imagen;
        }
        if (chocable instanceof SorpresaDesfavorable) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/gift.png").toURI().toString()));
            imagen.setOpacity(0.5);
            return imagen;
        }
        if (chocable instanceof SorpresaCambioVehiculo) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/gift.png").toURI().toString()));
            imagen.setOpacity(0.5);
            return imagen;
        }
        if (chocable instanceof Meta) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/finishline.png").toURI().toString()));
            return imagen;
        }
        else {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("").toURI().toString()));
            return imagen;
        }
    }

    public ImageView devolverImagenesVehiculos(Vehiculo vehiculo){
        if (vehiculo instanceof Auto) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/coche.png").toURI().toString()));
            return imagen;
        }
        if (vehiculo instanceof Moto) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/moto.png").toURI().toString()));
            return imagen;
        }
        if (vehiculo instanceof Todoterreno) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/vista/fotos/todoterreno.png").toURI().toString()));
            return imagen;
        }
        else {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("").toURI().toString()));
            return imagen;
        }
    }
}
