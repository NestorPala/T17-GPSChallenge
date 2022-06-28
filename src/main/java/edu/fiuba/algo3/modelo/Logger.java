package edu.fiuba.algo3.modelo;

public class Logger {
    private static Logger instance;
    private boolean activado = false;

    public static Logger getInstance() {
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void activar(){
        this.activado = true;
    }

    public void desactivar(){
        this.activado = false;
    }

    public void log(String unaAccion){
        if(activado){
            System.out.println(unaAccion);
        }
    }

}
