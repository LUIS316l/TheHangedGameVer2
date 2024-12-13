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
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import server.Servidor;

import utils.CloseAllWindows;

public class CreateScreen extends javax.swing.JFrame {

    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;
        
    private CustomeTextField textName;
    private CustomeTextField textRounds;
    private CustomeTextField textTimeWord;
    private CustomeTextField textWordsCant;
    private CustomeTextField textCodeGame;
    
    private Font labelFont = new Font("Doto", Font.BOLD, 20);
    private Color textColorLabel = Color.WHITE;
     
    public CreateScreen() {
        initComponents();
        isEscapePressed = false;
        addEscKeyListener();
        addCustomeTextField();
        IPAddress();
        startServer();
    }
    
    private void startServer() {
        int port = 12345;
        
        String playerName = textName.getText();
        String rounds = textRounds.getText();
        String timeWord = textTimeWord.getText();
        String wordsCant = textWordsCant.getText();
        
        Servidor servidor = new Servidor(port, playerName, rounds, timeWord, wordsCant);
        Thread servidorThread = new Thread(servidor);    
        servidorThread.start();
        
        System.out.println("SERVIDOR INICIADO EN EL PUERTO ---- " + port);
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
               
        JLabel label1 = new JLabel("NOMBRE: ");
        textName = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
        label1.setForeground(textColorLabel);

        JLabel label2 = new JLabel("RONDAS: ");
        textRounds = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label2.setFont(labelFont);
        label2.setForeground(textColorLabel);
        
        JLabel label3 = new JLabel("TIEMPO: ");
        textTimeWord = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label3.setFont(labelFont);
        label3.setForeground(textColorLabel);
               
        JLabel label5 = new JLabel("NUMERO DE PALABRAS: ");
        textWordsCant = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label5.setFont(labelFont);
        label5.setForeground(textColorLabel);
        
        // IP
        JLabel label6 = new JLabel("IP DEL SERVIDOR: ");
        textCodeGame = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label6.setFont(labelFont);
        label6.setForeground(textColorLabel);
                
        addCustomeList(textName, textRounds, textTimeWord, textWordsCant);

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
        panelComponents.add(label5, gbcCt); 
        
        gbcCt.gridy = 7; 
        panelComponents.add(textWordsCant, gbcCt); 
        
        gbcCt.gridy = 8;
        panelComponents.add(label6, gbcCt); 
        
        gbcCt.gridy = 9; 
        panelComponents.add(textCodeGame, gbcCt);

        panelComponents.revalidate();
        panelComponents.repaint();
    }
    
    private void addCustomeList(CustomeTextField textName, CustomeTextField textRounds, CustomeTextField textTimeWord, CustomeTextField textWordsCant ) {
        Dimension buttonSize = new Dimension(250, 50);
        Color colorBtnJoin = new Color(33, 77, 103);
        Color hoverBtnJoin = new Color(56, 182, 255);
        Color pressedColorBtnJoin = new Color(33, 77, 103);
        
        CustomeButton cbCs = new CustomeButton("INICIAR PARTIDA", buttonSize, colorBtnJoin, hoverBtnJoin, pressedColorBtnJoin);
        
        cbCs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String name = textName.getText().trim();
                String rounds = textRounds.getText().trim();
                String timeWords =textTimeWord.getText().trim();
                String wordsCant = textWordsCant.getText().trim();
                            
                GameScreen gs = new GameScreen(name, rounds, timeWords, wordsCant);
                
                gs.setVisible(true);
                gs.setLocationRelativeTo(null);
                
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
        
        JLabel label3 = new JLabel("JUGADORES ");
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
        panelList.add(cbCs, gbc);
        
        gbc.gridy = 10;
        panelList.add(cbCs, gbc);

        panelList.revalidate();
        panelList.repaint();
    }

    private void IPAddress() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            
            System.out.println("IP --- " + ip.getHostAddress());
            
            String host = ip.getHostAddress();
            
            textCodeGame.setText(host);
        } catch (UnknownHostException e) {
            System.out.println("No se pudo obtener la IP: " + e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelList;
    // End of variables declaration//GEN-END:variables
}
