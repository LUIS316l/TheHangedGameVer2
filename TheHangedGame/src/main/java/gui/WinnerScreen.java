package gui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import utils.CloseAllWindows;

public class WinnerScreen extends javax.swing.JFrame {

    private String player;
    
    public WinnerScreen(String msg, String player) {
        this.player = player;
        
        initComponents();
        addEnterKeyListener();
        
        lblText.setText(msg);
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
        panelWinner.addKeyListener(new KeyAdapter() {
           public void keyPressed(KeyEvent e) {
               if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                   HomeScreen hs = new HomeScreen();
                   
                   CloseAllWindows.cerrarTodasLasVentanas();
                   
                   hs.setVisible(true);
                   hs.setLocationRelativeTo(null);
                   
                   dispose();
               }
           }
        });
        panelWinner.setFocusable(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblExit;
    private javax.swing.JLabel lblPlayerName;
    private javax.swing.JLabel lblText;
    private javax.swing.JPanel panelWinner;
    // End of variables declaration//GEN-END:variables
}
