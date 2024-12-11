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

public class CreateScreen extends javax.swing.JFrame {

    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;
    
    private Font labelFont = new Font("Doto", Font.BOLD, 20);
    private Color textColorLabel = Color.WHITE;
    
    private String name;
    private String rounds;
    private String timeWords;
    private String words;
    private String wordsCant;
    private String codeGame;
     
    public CreateScreen() {
        initComponents();
        isEscapePressed = false;
        addEscKeyListener();
        addCustomeTextField();
        addCustomeList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComponents = new javax.swing.JPanel();
        panelList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelComponents.setBackground(new java.awt.Color(66, 130, 170));
        panelComponents.setPreferredSize(new java.awt.Dimension(450, 600));
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
            .addComponent(panelComponents, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(panelList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    
    
    private void addCustomeTextField() {
        int columns = 20;
        Dimension textFieldSize = new Dimension(250, 40);
        Color defaultColor = new Color(255, 255, 255);
        Color focusColor = new Color(200, 230, 250);
        Color textColor = Color.BLACK; 
        Color hoverColor = new Color(100, 200, 250);
        int radius = 15;
        
        
        JLabel label1 = new JLabel("USER NAME: ");
        CustomeTextField textName = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
        label1.setForeground(textColorLabel);

        JLabel label2 = new JLabel("ROUNDS: ");
        CustomeTextField textRounds = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label2.setFont(labelFont);
        label2.setForeground(textColorLabel);
        
        JLabel label3 = new JLabel("TIME: ");
        CustomeTextField textTimeWord = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label3.setFont(labelFont);
        label3.setForeground(textColorLabel);
        
        JLabel label4 = new JLabel("WORDS: ");
        CustomeTextField textWords = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label4.setFont(labelFont);
        label4.setForeground(textColorLabel);
        
        JLabel label5 = new JLabel("WORDS CANT: ");
        CustomeTextField textWordsCant = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label5.setFont(labelFont);
        label5.setForeground(textColorLabel);
        
        // IP
        JLabel label6 = new JLabel("CODE GAME: ");
        CustomeTextField textCodeGame = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label6.setFont(labelFont);
        label6.setForeground(textColorLabel);
        
        name = textName.getText();
        rounds = textRounds.getText();
        timeWords =textTimeWord.getText();
        words = textWords.getText();
        wordsCant = textWordsCant.getText();
        codeGame = textCodeGame.getText();

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
        panelComponents.add(textRounds, gbcCt); 
        
        gbcCt.gridy = 4;
        panelComponents.add(label3, gbcCt);

        gbcCt.gridy = 5; 
        panelComponents.add(textTimeWord, gbcCt); 

        gbcCt.gridy = 6;
        panelComponents.add(label4, gbcCt); 
        
        gbcCt.gridy = 7; 
        panelComponents.add(textWords, gbcCt); 
        
        gbcCt.gridy = 8;
        panelComponents.add(label5, gbcCt); 
        
        gbcCt.gridy = 9; 
        panelComponents.add(textWordsCant, gbcCt); 
        
        gbcCt.gridy = 10;
        panelComponents.add(label6, gbcCt); 
        
        gbcCt.gridy = 11; 
        panelComponents.add(textCodeGame, gbcCt);

        panelComponents.revalidate();
        panelComponents.repaint();
    }
    
    private void addCustomeList() {
        Dimension buttonSize = new Dimension(250, 50);
        Color colorBtnJoin = new Color(33, 77, 103);
        Color hoverBtnJoin = new Color(56, 182, 255);
        Color pressedColorBtnJoin = new Color(33, 77, 103);
        
        CustomeButton cbsg = new CustomeButton("START GAME", buttonSize, colorBtnJoin, hoverBtnJoin, pressedColorBtnJoin);
        
        cbsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AsignWordsScreen aws = new AsignWordsScreen();
                
                aws.setVisible(true);
                aws.setLocationRelativeTo(null);
                
                dispose();
            }        
        });
        
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Player 1");
        model.addElement("Player 2");
        model.addElement("Player 3");
        model.addElement("Player 4");
        model.addElement("Player 5");

        Dimension listSize = new Dimension(250, 200); 
        Color defaultColor = new Color(255, 255, 255);
        Color textColor = Color.BLACK;
        int borderRadius = 20;
        
        JLabel label3 = new JLabel("PLAYERS ");
        CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);
        label3.setFont(labelFont);
        label3.setForeground(textColorLabel);
        
        JLabel label4 = new JLabel("");
        JLabel label5 = new JLabel("");
        JLabel label6 = new JLabel("");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 15, 10, 0);
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridy = 4;
        panelList.add(label3, gbc); 
        
        gbc.gridy = 5;
        panelList.add(customeList, gbc); 
        
        gbc.gridy = 6;
        panelList.add(label4, gbc);
        
        gbc.gridy = 7;
        panelList.add(label5, gbc);
        
        gbc.gridy = 8;
        panelList.add(label6, gbc);
        
        gbc.gridy = 9;
        panelList.add(cbsg, gbc);

        panelList.revalidate();
        panelList.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelList;
    // End of variables declaration//GEN-END:variables
}
