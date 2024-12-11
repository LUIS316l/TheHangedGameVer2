package gui;

import customeComponents.CustomeButton;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.CloseAllWindows;


public class SinglePlayerScreen extends JFrame {
    
    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;

    public SinglePlayerScreen() {
        initComponents();
        isEscapePressed = false;
        addCustomeTextField();
        addEscKeyListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComponents = new javax.swing.JPanel();
        panelImage = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelComponents.setBackground(new java.awt.Color(66, 130, 170));
        panelComponents.setPreferredSize(new java.awt.Dimension(450, 600));
        panelComponents.setLayout(new java.awt.GridBagLayout());

        panelImage.setBackground(new java.awt.Color(47, 89, 114));
        panelImage.setPreferredSize(new java.awt.Dimension(450, 600));

        javax.swing.GroupLayout panelImageLayout = new javax.swing.GroupLayout(panelImage);
        panelImage.setLayout(panelImageLayout);
        panelImageLayout.setHorizontalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        panelImageLayout.setVerticalGroup(
            panelImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelComponents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        
        HomeScreen hs = new HomeScreen();
                   
        hs.setVisible(true);
        hs.setLocationRelativeTo(null);

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
        
        Font labelFont = new Font("Doto", Font.BOLD, 20);

        JLabel label1 = new JLabel("USER NAME: ");
        CustomeTextField textName = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
         
        JLabel label2 = new JLabel("ROUNDS: ");
        CustomeTextField textRounds = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label2.setFont(labelFont);
        
        JLabel label3 = new JLabel("WORD TIME: ");
        CustomeTextField textTime = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label3.setFont(labelFont);
        
        JLabel label4 = new JLabel("WORD CANT: ");
        CustomeTextField textWordsCant = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label4.setFont(labelFont);
        
        addCustomeButton(textName, textRounds, textTime, textWordsCant);
        
        JLabel label5 = new JLabel(" ");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 15, 10, 0); 
        gbc.anchor = GridBagConstraints.WEST; 

        gbc.gridy = 0;
        panelComponents.add(label1, gbc);

        gbc.gridy = 1; 
        panelComponents.add(textName, gbc); 

        gbc.gridy = 2;
        panelComponents.add(label2, gbc); 

        gbc.gridy = 3;
        panelComponents.add(textRounds, gbc); 

        gbc.gridy = 4;
        panelComponents.add(label3, gbc); 

        gbc.gridy = 5;
        panelComponents.add(textTime, gbc); 
        
        gbc.gridy = 6;
        panelComponents.add(label4, gbc); 
        
        gbc.gridy = 7;
        panelComponents.add(textWordsCant, gbc); 

        gbc.gridy = 8;
        panelComponents.add(label5, gbc);

        panelComponents.revalidate();
        panelComponents.repaint();
    }
    
    private void addCustomeButton(CustomeTextField textName, CustomeTextField textRounds, CustomeTextField textTime, CustomeTextField textWordsCant) {
        Dimension buttonSize = new Dimension(250, 50);
        Color colorBtnSingle = new Color(33, 77, 103);
        Color hoverBtnSingle = new Color(56, 182, 255);
        Color pressedColorBtnSingle = new Color(33, 77, 103);
                
        CustomeButton cbsp = new CustomeButton("START GAME", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);
        
        cbsp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String playerName = textName.getText().trim();
                String rounds = textRounds.getText().trim();
                String timeWords = textTime.getText().trim();
                String wordsCant = textWordsCant.getText().trim();
                
                GameScreen gs = new GameScreen(playerName, rounds, timeWords, wordsCant);
                
                gs.setVisible(true);
                gs.setLocationRelativeTo(null);
                
                dispose();
            }        
        }); 
        
        GridBagConstraints gbcSingle = new GridBagConstraints();
        gbcSingle.gridx = 0; 
        gbcSingle.gridy = 9;    
        gbcSingle.insets = new Insets(10, 10, 10, 10); 
        gbcSingle.anchor = GridBagConstraints.CENTER;
               
        panelComponents.add(cbsp, gbcSingle);
        panelComponents.revalidate();
        panelComponents.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelImage;
    // End of variables declaration//GEN-END:variables
}
