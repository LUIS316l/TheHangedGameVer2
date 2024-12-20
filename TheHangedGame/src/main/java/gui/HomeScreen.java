package gui;

import customeComponents.CustomeButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;

public class HomeScreen extends JFrame {
    
    // INSTANCIAS Y VARIABLES
            
  // Constructor de la clase HomeScreen
public HomeScreen() {
    initComponents(); // Inicializa los componentes de la interfaz
    addCustomeButton(); // Agrega los botones personalizados
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSingle = new javax.swing.JPanel();
        panelMulti = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelSingle.setBackground(new java.awt.Color(66, 130, 170));
        panelSingle.setPreferredSize(new java.awt.Dimension(500, 0));
        panelSingle.setLayout(new java.awt.GridBagLayout());

        panelMulti.setBackground(new java.awt.Color(47, 89, 114));
        panelMulti.setPreferredSize(new java.awt.Dimension(500, 0));
        panelMulti.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSingle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelMulti, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   // Método para agregar botones personalizados
private void addCustomeButton() {
    Dimension buttonSize = new Dimension(250, 50); // Tamaño de los botones

    // Configuración de colores para los botones
    Color colorBtnSingle = new Color(33, 77, 103);
    Color hoverBtnSingle = new Color(56, 182, 255);
    Color pressedColorBtnSingle = new Color(33, 77, 103);

    Color colorBtnMulti = new Color(66, 120, 170);
    Color hoverBtnMilti = new Color(56, 182, 255);
    Color pressedColorBtnMulti = new Color(66, 120, 170);

    // Creación de los botones personalizados
    CustomeButton cbsp = new CustomeButton("SINGLE PLAYER", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);
    CustomeButton cbmp = new CustomeButton("MULTI PLAYER", buttonSize, colorBtnMulti, hoverBtnMilti, pressedColorBtnMulti);

    // Añade acciones a los botones
    cbsp.addActionListener(e -> NavigationManager.navigateTo(this, new SinglePlayerScreen()));
    cbmp.addActionListener(e -> NavigationManager.navigateTo(this, new JoinOrCreate()));

    // Configuración de las restricciones de diseño
    GridBagConstraints gbcSingle = new GridBagConstraints();
    gbcSingle.gridx = 0;
    gbcSingle.gridy = 0;
    gbcSingle.insets = new Insets(10, 10, 10, 10);
    gbcSingle.anchor = GridBagConstraints.CENTER;

    GridBagConstraints gbcMulti = new GridBagConstraints();
    gbcMulti.gridx = 0;
    gbcMulti.gridy = 0;
    gbcMulti.insets = new Insets(10, 10, 10, 10);
    gbcMulti.anchor = GridBagConstraints.CENTER;

    // Agrega los botones a los paneles correspondientes
    panelSingle.add(cbsp, gbcSingle);
    panelSingle.revalidate();
    panelSingle.repaint();

    panelMulti.add(cbmp, gbcMulti);
    panelMulti.revalidate();
    panelMulti.repaint();
    }
    
  // Clase de gestión de navegación entre pantallas
public class NavigationManager {
    public static void navigateTo(JFrame current, JFrame next) {
        next.setVisible(true); // Muestra la nueva pantalla
        next.setLocationRelativeTo(null); // Centra la nueva pantalla
        current.dispose(); // Cierra la pantalla actual
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelMulti;
    private javax.swing.JPanel panelSingle;
    // End of variables declaration//GEN-END:variables
}
