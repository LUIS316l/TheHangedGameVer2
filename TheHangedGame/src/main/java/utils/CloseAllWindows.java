package utils;

import java.awt.Window;

public class CloseAllWindows {

    public static void cerrarTodasLasVentanas() {
        Window[] windows = Window.getWindows();
        System.out.println("Número de ventanas activas: " + windows.length);

        for (Window window : windows) {
            if (window.isVisible() && window.isDisplayable()) {
                System.out.println("Cerrando ventana: " + window.getClass().getName());
                window.dispose();
            }
        }
    }
}
