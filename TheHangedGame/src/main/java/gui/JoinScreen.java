package gui;

import customeComponents.CustomeList;
import customeComponents.CustomeTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import server.Cliente;
import utils.CloseAllWindows;

public class JoinScreen extends javax.swing.JFrame {

    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;
    
    private Font labelFont = new Font("Doto", Font.BOLD, 20);
    private Color textColorLabel = Color.WHITE;

    private CustomeTextField textName;
    private CustomeTextField textCode;
        
    public JoinScreen() {
        initComponents();
        isEscapePressed = false;
        addEscKeyListener();
        addCustomeTextField();
        addCustomeList();
    }
    
    private void startClient() {
        String ip = textCode.getText();
        String playerName = textName.getText();
        
        String serverAddress = ip;
        int port = 12345;
        
        Cliente cliente = new Cliente(serverAddress, port, playerName);
        Thread clienteThread = new Thread(cliente); 
        clienteThread.start();
        
        System.out.println("CLIENTE CONECTANDOSE AL SERVIDOR " + serverAddress + ":" + port);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComponents = new javax.swing.JPanel();
        panelInfo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelComponents.setBackground(new java.awt.Color(66, 130, 170));
        panelComponents.setForeground(new java.awt.Color(255, 255, 255));
        panelComponents.setPreferredSize(new java.awt.Dimension(450, 600));
        panelComponents.setLayout(new java.awt.GridBagLayout());

        panelInfo.setBackground(new java.awt.Color(47, 89, 114));
        panelInfo.setPreferredSize(new java.awt.Dimension(450, 600));
        panelInfo.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    startClient();
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
    
      
    private void addCustomeTextField() {
        int columns = 20;
        Dimension textFieldSize = new Dimension(250, 40);
        Color defaultColor = new Color(255, 255, 255);
        Color focusColor = new Color(200, 230, 250);
        Color textColor = Color.BLACK; 
        Color hoverColor = new Color(100, 200, 250);
        int radius = 15;
        
        
        JLabel label1 = new JLabel("USER NAME: ");
        textName = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
        label1.setForeground(textColorLabel);
         
        JLabel label2 = new JLabel("CODE GAME: ");
        textCode = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label2.setFont(labelFont);
        label2.setForeground(textColorLabel);
        
        GridBagConstraints gbcCt = new GridBagConstraints();
        gbcCt.gridx = 0;
        gbcCt.insets = new Insets(10, 15, 10, 0); 
        gbcCt.anchor = GridBagConstraints.WEST; 

        gbcCt.gridy = 0;
        panelComponents.add(label1, gbcCt);

        gbcCt.gridy = 1; 
        panelComponents.add(textName, gbcCt); 

        gbcCt.gridy = 2;
        panelComponents.add(label2, gbcCt); 

        gbcCt.gridy = 3;
        panelComponents.add(textCode, gbcCt); 

        panelComponents.revalidate();
        panelComponents.repaint();
    }
    
    private void addCustomeList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Player 1");
        model.addElement("Player 2");
        model.addElement("Player 3");
        model.addElement("Player 4");
  
        Dimension listSize = new Dimension(250, 200); 
        Color defaultColor = new Color(255, 255, 255);
        Color textColor = Color.BLACK;
        int borderRadius = 20;
        
        JLabel label3 = new JLabel("PLAYERS ");
        CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);
        label3.setFont(labelFont);
        label3.setForeground(textColorLabel);

        GridBagConstraints gbcCl = new GridBagConstraints();
        gbcCl.gridx = 0;
        gbcCl.insets = new Insets(10, 15, 10, 0);
        gbcCl.anchor = GridBagConstraints.WEST;
        
        gbcCl.gridy = 4;
        panelComponents.add(label3, gbcCl); 
        
        gbcCl.gridy = 5;
        panelComponents.add(customeList, gbcCl); 

        panelComponents.revalidate();
        panelComponents.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelInfo;
    // End of variables declaration//GEN-END:variables
}
