package gui;

import customeComponents.CustomeButton;
import customeComponents.CustomeList;
import customeComponents.CustomeTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import utils.CloseAllWindows;

public class AsignWordsScreen extends javax.swing.JFrame {

    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;
    
    private Font labelFont = new Font("Doto", Font.BOLD, 20);
    private Color textColorLabel = Color.WHITE;
    
    public AsignWordsScreen() {
        initComponents();
        isEscapePressed = false;
        addCustomeTextFieldAndButton();
        addCustomeList();
        addEscKeyListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComponents = new javax.swing.JPanel();
        panelList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelComponents.setBackground(new java.awt.Color(66, 130, 170));
        panelComponents.setPreferredSize(new java.awt.Dimension(450, 600));
        panelComponents.setRequestFocusEnabled(false);
        panelComponents.setLayout(new java.awt.GridBagLayout());

        panelList.setBackground(new java.awt.Color(47, 89, 114));
        panelList.setPreferredSize(new java.awt.Dimension(450, 600));
        panelList.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEscKeyListener() {
        escKeyDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    abrirVentanaAnterior();
                    return true;
                }
                return false; 
            }
        };

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher);
    }
    
    
    private void abrirVentanaAnterior() {
        if (isEscapePressed) {
            return;
        }
        
        isEscapePressed = true;
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
        
        CloseAllWindows.cerrarTodasLasVentanas();
        
        JoinOrCreate joc = new JoinOrCreate();
                   
        joc.setVisible(true);
        joc.setLocationRelativeTo(null);

        this.dispose();
    }
    
    private void addCustomeTextFieldAndButton() {
        int columns = 20;
        Dimension textFieldSize = new Dimension(250, 40);
        Color defaultColor = new Color(255, 255, 255);
        Color focusColor = new Color(200, 230, 250);
        Color textColor = Color.BLACK; 
        Color hoverColor = new Color(100, 200, 250);
        int radius = 15;
        
        JLabel label1 = new JLabel("WORDS CANT --> ");
        CustomeTextField textField1 = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
        label1.setForeground(textColorLabel);
         
        JLabel label2 = new JLabel("ENTER para agregar");
        label2.setFont(labelFont);
        label2.setForeground(textColorLabel);
        
        Dimension buttonSize = new Dimension(250, 50);
        Color colorBtnJoin = new Color(33, 77, 103);
        Color hoverBtnJoin = new Color(56, 182, 255);
        Color pressedColorBtnJoin = new Color(33, 77, 103);
        
        CustomeButton cbt = new CustomeButton("TERMINAR", buttonSize, colorBtnJoin, hoverBtnJoin, pressedColorBtnJoin);
        
        cbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameScreen gs = new GameScreen(null, null, null, null);
                
                gs.setVisible(true);
                gs.setLocationRelativeTo(null);
                
                dispose();
            }        
        });
      
        JLabel label3 = new JLabel("");
        JLabel label4 = new JLabel("");
        JLabel label5 = new JLabel("");
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 15, 10, 0); 
        gbc.anchor = GridBagConstraints.WEST; 

        gbc.gridy = 0;
        panelComponents.add(label1, gbc);

        gbc.gridy = 1; 
        panelComponents.add(textField1, gbc); 

        gbc.gridy = 2;
        panelComponents.add(label2, gbc); 
        
        gbc.gridy = 3;
        panelComponents.add(label3, gbc);
        
        gbc.gridy = 4;
        panelComponents.add(label4, gbc);
        
        gbc.gridy = 5;
        panelComponents.add(label5, gbc);

        gbc.gridy = 6;
        panelComponents.add(cbt, gbc);
        
        panelComponents.revalidate();
        panelComponents.repaint();
    }
    
    private void addCustomeList() {
       
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Palabra 1");
        model.addElement("Palabra 2");
        model.addElement("Palabra 3");
        model.addElement("Palabra 4");
        model.addElement("Palabra 5");

        Dimension listSize = new Dimension(250, 500); 
        Color defaultColor = new Color(255, 255, 255);
        Color textColor = Color.BLACK;
        int borderRadius = 20;
        
        CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 15, 10, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridy = 1;
        panelList.add(customeList, gbc); 

        panelList.revalidate();
        panelList.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelList;
    // End of variables declaration//GEN-END:variables
}
