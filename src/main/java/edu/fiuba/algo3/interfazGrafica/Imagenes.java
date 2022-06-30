package edu.fiuba.algo3.interfazGrafica;

import edu.fiuba.algo3.modelo.Chocables.*;

public class Imagenes {

    public Imagenes(){};

    public String devolverImagen(ControlPolicial controlPolicial){
        return "src/main/java/edu/fiuba/algo3/interfazGrafica/police.png";
    };

    public String devolverImagen(Piquete piquete){
        return "src/main/java/edu/fiuba/algo3/interfazGrafica/manifestation.png";
    };

    public String devolverImagen(Pozo pozo){
        return "src/main/java/edu/fiuba/algo3/interfazGrafica/pozo.png";
    };

    public String devolverImagen(SorpresaFavorable sorpresaFavorable){
        return "src/main/java/edu/fiuba/algo3/interfazGrafica/gift.png";
    };

    public String devolverImagen(SorpresaDesfavorable sorpresaDesfavorable){
        return "src/main/java/edu/fiuba/algo3/interfazGrafica/gift.png";
    };

    public String devolverImagen(SorpresaCambioVehiculo sorpresaCambioVehiculo){
        return "src/main/java/edu/fiuba/algo3/interfazGrafica/gift.png";
    };
}
