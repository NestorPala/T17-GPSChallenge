package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Chocables.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Imagenes {

    public Imagenes() {};

    public ImageView devolverImagenes(Chocable chocable) {
        if (chocable instanceof ControlPolicial) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/police.png").toURI().toString()));
            return imagen;
        }
        if (chocable instanceof Pozo) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/pozo.png").toURI().toString()));
            return imagen;
        }
        if (chocable instanceof Piquete) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/manifestation.png").toURI().toString()));
            return imagen;
        }
        if (chocable instanceof SorpresaFavorable) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/gift.png").toURI().toString()));
            return imagen;
        }
        if (chocable instanceof SorpresaDesfavorable) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/gift.png").toURI().toString()));
            return imagen;
        }
        if (chocable instanceof SorpresaCambioVehiculo) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/interfazGrafica/gift.png").toURI().toString()));
            return imagen;
        } else {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("").toURI().toString()));
            return imagen;
        }
    }
}
