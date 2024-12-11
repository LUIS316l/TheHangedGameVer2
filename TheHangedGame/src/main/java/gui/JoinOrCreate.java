package gui;

import customeComponents.CustomeButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import utils.CloseAllWindows;

public class JoinOrCreate extends javax.swing.JFrame {
    
    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;

    private static JoinOrCreate instance = null;

    public JoinOrCreate() {
        initComponents();
        isEscapePressed = false;
        addCustomeButton();
        addEscKeyListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelJoin = new javax.swing.JPanel();
        panelCreate = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelJoin.setBackground(new java.awt.Color(66, 130, 170));
        panelJoin.setPreferredSize(new java.awt.Dimension(450, 600));
        panelJoin.setLayout(new java.awt.GridBagLayout());

        panelCreate.setBackground(new java.awt.Color(47, 89, 114));
        panelCreate.setPreferredSize(new java.awt.Dimension(450, 600));
        panelCreate.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelJoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static JoinOrCreate getInstance() {
        if (instance == null || !instance.isDisplayable()) {
            instance = new JoinOrCreate();
        }
        return instance;
    }
    
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
    
    @Override
    public void dispose() {
        instance = null; // Asegúrate de liberar la referencia del singleton
        super.dispose();
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

        dispose();
    }
    
    private void addCustomeButton() {
        Dimension buttonSize = new Dimension(250, 50);
        Color colorBtnJoin = new Color(33, 77, 103);
        Color hoverBtnJoin = new Color(56, 182, 255);
        Color pressedColorBtnJoin = new Color(33, 77, 103);
        
        Color colorBtnCreate = new Color(66, 120, 170);
        Color hoverBtnCreate = new Color(56, 182, 255);
        Color pressedColorBtnCreate = new Color(66, 120, 170);
        
        CustomeButton cbjg = new CustomeButton("JOIN GAME", buttonSize, colorBtnJoin, hoverBtnJoin, pressedColorBtnJoin);
        CustomeButton cbcg = new CustomeButton("CREATE GAME", buttonSize, colorBtnCreate, hoverBtnCreate, pressedColorBtnCreate);
               
        cbjg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JoinScreen js = new JoinScreen();
                
                js.setVisible(true);
                js.setLocationRelativeTo(null);
                
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
                
                dispose();
            }        
        });
        
        cbcg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateScreen cs = new CreateScreen();
                
                cs.setVisible(true);
                cs.setLocationRelativeTo(null);
                
                KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
                
                dispose();
            }        
        });
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.gridy = 0; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.CENTER;
        
        panelJoin.add(cbjg, gbc);
        panelJoin.revalidate();
        panelJoin.repaint();
        
        panelCreate.add(cbcg, gbc);
        panelCreate.revalidate();
        panelCreate.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelCreate;
    private javax.swing.JPanel panelJoin;
    // End of variables declaration//GEN-END:variables
}
