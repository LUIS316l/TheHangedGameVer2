package utils;

import java.awt.Window;

public class CloseAllWindows {

    // Método para cerrar todas las ventanas visibles y desplegables
    public static void cerrarTodasLasVentanas() {
        // Obtener todas las ventanas abiertas en el sistema
        Window[] windows = Window.getWindows();
        
        // Imprimir el número de ventanas activas
        System.out.println("Número de ventanas activas: " + windows.length);

        // Iterar sobre todas las ventanas abiertas
        for (Window window : windows) {
            // Verificar si la ventana está visible y es desplegable (es decir, está completamente cargada y puede cerrarse)
            if (window.isVisible() && window.isDisplayable()) {
                // Imprimir el nombre de la clase de la ventana que se está cerrando
                System.out.println("Cerrando ventana: " + window.getClass().getName());
                
                // Cerrar la ventana
                window.dispose();
            }
        }
    }
}
