package gui;

import customeComponents.CustomeButton;
import customeComponents.CustomeList;
import customeComponents.CustomeTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

public class PRUEBASDEBOTONES extends javax.swing.JFrame {

    public PRUEBASDEBOTONES() {
        initComponents();
        addCustomeComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(66, 130, 170));
        panel.setPreferredSize(new java.awt.Dimension(900, 600));
        panel.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCustomeComponents() {
        // Datos de ejemplo para la lista
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Elemento 1");
        model.addElement("Elemento 2");
        model.addElement("Elemento 3");
        model.addElement("Elemento 4");
        model.addElement("Elemento 5");

        // Configuración de la lista personalizada
        Dimension listSize = new Dimension(300, 200); // Ancho y alto de la lista
        Color defaultColor = new Color(255, 255, 255);
        Color textColor = Color.BLACK;
        int borderRadius = 20;

        CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);

        // Usar GridBagConstraints para colocar la lista en el panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.anchor = GridBagConstraints.CENTER;

        panel.add(customeList, gbc);
        panel.revalidate();
        panel.repaint();
    }
    
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRUEBASDEBOTONES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
