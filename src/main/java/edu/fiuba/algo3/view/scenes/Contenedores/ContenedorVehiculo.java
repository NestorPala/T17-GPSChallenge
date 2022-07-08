package edu.fiuba.algo3.view.scenes.Contenedores;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ContenedorVehiculo {

    final Label tipo;
    final ImageView imagen;

    public ContenedorVehiculo(Label unTipo, ImageView unaImagen) {
        this.tipo = unTipo;
        this.imagen = unaImagen;
    }

    public Label obtenerTipo() {
        return this.tipo;
    }

    public ImageView obtenerImagen() {
        return this.imagen;
    }
}
