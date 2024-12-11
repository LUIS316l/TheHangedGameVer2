package utils;

import javax.swing.SwingUtilities;

public class ThreadTimer {
    
    public static void execute(int delayMillis, Runnable task) {
        new Thread(() -> {
            try {
                Thread.sleep(delayMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            SwingUtilities.invokeLater(task);
        }).start();
    }
}
