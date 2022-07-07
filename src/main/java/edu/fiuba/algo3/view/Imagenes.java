package edu.fiuba.algo3.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

import edu.fiuba.algo3.model.Chocables.*;
import edu.fiuba.algo3.model.Vehiculos.Auto;
import edu.fiuba.algo3.model.Vehiculos.Moto;
import edu.fiuba.algo3.model.Vehiculos.Todoterreno;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class Imagenes {

    public Imagenes() {}

    public ImageView devolverImagenes(Chocable chocable) {
        /*if (chocable instanceof ControlPolicial) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/police.png").toURI().toString()));
            imagen.setOpacity(0.625);
            return imagen;
        }
        if (chocable instanceof Pozo) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/pozo.png").toURI().toString()));
            imagen.setOpacity(0.625);
            return imagen;
        }
        if (chocable instanceof Piquete) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/manifestation.png").toURI().toString()));
            imagen.setOpacity(0.625);
            return imagen;
        }
        if (chocable instanceof SorpresaFavorable) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/gift.png").toURI().toString()));
            imagen.setOpacity(0.625);
            return imagen;
        }
        if (chocable instanceof SorpresaDesfavorable) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/gift.png").toURI().toString()));
            imagen.setOpacity(0.625);
            return imagen;
        }
        if (chocable instanceof SorpresaCambioVehiculo) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/gift.png").toURI().toString()));
            imagen.setOpacity(0.75);
            return imagen;
        }
        if (chocable instanceof Meta) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/finishline.png").toURI().toString()));
            imagen.setId("Meta");
            return imagen;
        }
        else {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("").toURI().toString()));
            return imagen;
        }*/
        ImageView imagen = new ImageView();
        imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/" + chocable.toString() + ".png").toURI().toString()));
        imagen.setOpacity(0.625);
        if(chocable.toString().equals("meta")){
            imagen.setId("Meta");
            imagen.setOpacity(1);
        }
        return imagen;
    }

    public ImageView devolverImagenesVehiculos(Vehiculo vehiculo){
        /*if (vehiculo instanceof Auto) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/coche.png").toURI().toString()));
            imagen.setId("Auto");
            return imagen;
        }
        if (vehiculo instanceof Moto) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/moto.png").toURI().toString()));
            imagen.setId("Moto");
            return imagen;
        }
        if (vehiculo instanceof Todoterreno) {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/todoterreno.png").toURI().toString()));
            imagen.setId("Todoterreno");
            return imagen;
        }
        else {
            ImageView imagen = new ImageView();
            imagen.setImage(new Image(new File("").toURI().toString()));
            return imagen;
        }*/
        ImageView imagen = new ImageView();
        imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/" + vehiculo.toString() + ".png").toURI().toString()));
        imagen.setId(vehiculo.toString().substring(0,1).toUpperCase() + vehiculo.toString().substring(1).toLowerCase()); // Para poner en mayusculas la primer letra.
        return imagen;
    }
}
