// Declara el paquete de la clase.
package com.wenlui.thehangedgame;

// Importa la clase SplashScreen del paquete gui.
import gui.SplashScreen;

// Clase principal del juego.
public class TheHangedGame {

    // Método principal que inicia la aplicación.
    public static void main(String[] args) {

        // Crea una pantalla de bienvenida.
        SplashScreen splash = new SplashScreen();

        // Muestra la pantalla de bienvenida.
        splash.setVisible(true);

        // Centra la pantalla de bienvenida.
        splash.setLocationRelativeTo(null);
    }
}
