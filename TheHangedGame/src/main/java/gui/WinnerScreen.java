package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import utils.CloseAllWindows;

public class WinnerScreen extends javax.swing.JFrame {

    // Definición de una variable privada de tipo String que almacena el nombre del jugador
private String player;
    
// Constructor de la clase WinnerScreen, que recibe un mensaje y el nombre de un jugador
public WinnerScreen(String msg, String player) {
    // Asigna el nombre del jugador al campo player
    this.player = player;
        
    // Inicializa los componentes de la interfaz gráfica (normalmente generados por el diseñador de interfaz gráfica)
    initComponents();
    
    // Agrega el escuchador de la tecla Enter para que la pantalla responda a dicha tecla
    addEnterKeyListener();
    
    // Establece el texto del JLabel lblText con el mensaje recibido como parámetro
    lblText.setText(msg);
    
    // Establece el texto del JLabel lblPlayerName con el nombre del jugador recibido como parámetro
    lblPlayerName.setText(player);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelWinner = new javax.swing.JPanel();
        lblExit = new javax.swing.JLabel();
        lblText = new javax.swing.JLabel();
        lblPlayerName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelWinner.setBackground(new java.awt.Color(66, 130, 170));

        lblExit.setFont(new java.awt.Font("Doto", 1, 20)); // NOI18N
        lblExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExit.setText("ESC para volver al menu principal");

        lblText.setFont(new java.awt.Font("Doto", 1, 55)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("WINNER");

        lblPlayerName.setFont(new java.awt.Font("Doto", 1, 55)); // NOI18N
        lblPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlayerName.setText("JUGADOR");

        javax.swing.GroupLayout panelWinnerLayout = new javax.swing.GroupLayout(panelWinner);
        panelWinner.setLayout(panelWinnerLayout);
        panelWinnerLayout.setHorizontalGroup(
            panelWinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblExit, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
            .addComponent(lblPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelWinnerLayout.setVerticalGroup(
            panelWinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWinnerLayout.createSequentialGroup()
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblExit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelWinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addEnterKeyListener() {
    // Se añade un KeyListener al panelWinner para escuchar las teclas presionadas
    panelWinner.addKeyListener(new KeyAdapter() {
        // Método que se ejecuta cuando se presiona una tecla
        public void keyPressed(KeyEvent e) {
            // Verifica si la tecla presionada es la tecla Enter
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                // Si es Enter, crea una nueva instancia de la pantalla HomeScreen
                HomeScreen hs = new HomeScreen();
                
                // Cierra todas las ventanas abiertas antes de mostrar la nueva pantalla
                CloseAllWindows.cerrarTodasLasVentanas();
                
                // Muestra la nueva pantalla y la coloca en el centro de la pantalla
                hs.setVisible(true);
                hs.setLocationRelativeTo(null);
                
                // Cierra la ventana actual (panelWinner)
                dispose();
            }
        }
    });
    
    // Establece que el panelWinner puede recibir eventos de teclado
    panelWinner.setFocusable(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblText;
    private javax.swing.JPanel panelWinner;
    // End of variables declaration//GEN-END:variables
}
