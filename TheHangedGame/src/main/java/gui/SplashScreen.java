package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SplashScreen extends javax.swing.JFrame {

   // Constructor de la clase SplashScreen
public SplashScreen() {
    // Inicializa los componentes de la ventana (normalmente generados por el diseñador de interfaz gráfica)
    initComponents();
    
    // Agrega el escuchador de teclas para que el panel responda a las teclas presionadas
    addEnterKeyListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSplash = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelSplash.setBackground(new java.awt.Color(66, 130, 170));

        jLabel1.setFont(new java.awt.Font("Doto", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THE HANGED GAME");

        jLabel4.setFont(new java.awt.Font("Doto", 2, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SPACE para continuar / ENTER para ver las palabras /  ESC para ver como jugar");

        jLabel2.setFont(new java.awt.Font("Doto", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/Imagen.png"))); // NOI18N

        javax.swing.GroupLayout panelSplashLayout = new javax.swing.GroupLayout(panelSplash);
        panelSplash.setLayout(panelSplashLayout);
        panelSplashLayout.setHorizontalGroup(
            panelSplashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSplashLayout.setVerticalGroup(
            panelSplashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSplashLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSplash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSplash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   // Método que agrega un escuchador de teclas (key listener) para detectar cuando se presionan teclas específicas en el panel.
private void addEnterKeyListener() {
    // Se agrega un KeyListener al panel 'panelSplash', para que detecte los eventos de teclado.
    panelSplash.addKeyListener(new KeyAdapter() {
        
        // Método que se ejecuta cuando se presiona una tecla.
        public void keyPressed(KeyEvent e) {
            
            // Si la tecla presionada es la barra espaciadora (Space), realiza las siguientes acciones:
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                // Crea una nueva instancia de la pantalla principal 'HomeScreen'.
                HomeScreen hs = new HomeScreen();
                
                // Hace visible la ventana de la pantalla principal.
                hs.setVisible(true);
                
                // Centra la pantalla en la pantalla del usuario.
                hs.setLocationRelativeTo(null);
                
                // Cierra la ventana actual (en la que se detectó la tecla).
                dispose();
                
            // Si la tecla presionada es ESCAPE, realiza las siguientes acciones:
            } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // Crea una nueva instancia de la pantalla 'HowGameScreen'.
                HowGameScreen hgs = new HowGameScreen();
                
                // Hace visible la ventana de la pantalla de instrucciones del juego.
                hgs.setVisible(true);
                
                // Centra la pantalla de instrucciones en la pantalla del usuario.
                hgs.setLocationRelativeTo(null);
                
                // Cierra la ventana actual.
                dispose();
                
            // Si la tecla presionada es ENTER, realiza las siguientes acciones:
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Crea una nueva instancia de la pantalla de administración 'ADMscreen'.
                ADMscreen adms = new ADMscreen();
                
                // Hace visible la ventana de administración.
                adms.setVisible(true);
                
                // Centra la pantalla de administración en la pantalla del usuario.
                adms.setLocationRelativeTo(null);
                
                // Cierra la ventana actual.
                dispose();
            }
        }
    });
    
    // Hace que el panel 'panelSplash' sea capaz de recibir eventos de teclado.
    panelSplash.setFocusable(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelSplash;
    // End of variables declaration//GEN-END:variables
}
