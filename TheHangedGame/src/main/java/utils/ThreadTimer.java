package utils;

import javax.swing.SwingUtilities;

public class ThreadTimer {
    
    // Método para ejecutar una tarea después de un retraso en milisegundos
    public static void execute(int delayMillis, Runnable task) {
        // Crear un nuevo hilo para ejecutar la tarea después del retraso
        new Thread(() -> {
            try {
                // Pausar el hilo durante el tiempo especificado en milisegundos
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                // Si el hilo es interrumpido, imprimir el error
                e.printStackTrace();
            }

            // Después del retraso, ejecutar la tarea en el hilo de eventos de la interfaz gráfica
            SwingUtilities.invokeLater(task);
        }).start(); // Iniciar el hilo
    }
}
