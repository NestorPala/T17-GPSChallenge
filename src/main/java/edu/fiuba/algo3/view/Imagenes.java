package edu.fiuba.algo3.view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

import edu.fiuba.algo3.model.Chocables.*;
import edu.fiuba.algo3.model.Vehiculos.Vehiculo;

public class Imagenes {

    public Imagenes() {}

    public ImageView devolverImagenes(Chocable chocable) {
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
        ImageView imagen = new ImageView();
        imagen.setImage(new Image(new File("src/main/java/edu/fiuba/algo3/view/fotos/" + vehiculo.toString() + ".png").toURI().toString()));
        imagen.setId(vehiculo.toString());
        return imagen;
    }
}
