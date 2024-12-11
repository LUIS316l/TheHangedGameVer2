package gui;

import customeComponents.CustomeButton;
import customeComponents.CustomeTable;
import customeComponents.CustomeTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import server.dbConnection;
import utils.CloseAllWindows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADMscreen extends javax.swing.JFrame {
    
    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;

    public ADMscreen() {
        initComponents();
        isEscapePressed = false;
        addCustomeButtons();
        addCustomeTable();
        addEscKeyListener();
    }

    private void addEscKeyListener() {
        escKeyDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    abrirVentanaSiguiente();
                    return true;
                }
                return false; 
            }
        };

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher);
    }
    
    
    private void abrirVentanaSiguiente() {
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
    
    private void addCustomeButtons() {
        Dimension buttonSize = new Dimension(250, 50);
        Color colorBtnSingle = new Color(33, 77, 103);
        Color hoverBtnSingle = new Color(56, 182, 255);
        Color pressedColorBtnSingle = new Color(33, 77, 103);
        
        int columns = 20;
        Dimension textFieldSize = new Dimension(250, 40);
        Color defaultColor = new Color(255, 255, 255);
        Color focusColor = new Color(200, 230, 250);
        Color textColor = Color.BLACK; 
        Color hoverColor = new Color(100, 200, 250);
        int radius = 15;
        
        Font labelFont = new Font("Doto", Font.BOLD, 20);
        
        JLabel label1 = new JLabel("ID: ");
        CustomeTextField textID = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
         
        JLabel label2 = new JLabel("PALABRA: ");
        CustomeTextField textWord = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label2.setFont(labelFont);
        
        JLabel label3 = new JLabel(" ");
        JLabel label4 = new JLabel(" ");
        JLabel label5 = new JLabel(" ");

        
        CustomeButton cbAdd = new CustomeButton("AGREGAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);
        
        cbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }        
        });
        
        CustomeButton cbUpdate= new CustomeButton("MODIFICAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);
        CustomeButton cbDelete = new CustomeButton("ELIMINAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; 
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.anchor = GridBagConstraints.CENTER;
        
        gbc.gridy = 1; 
        panelComponents.add(label1, gbc); 

        gbc.gridy = 2;
        panelComponents.add(textID, gbc);
        
        gbc.gridy = 3; 
        panelComponents.add(label2, gbc); 

        gbc.gridy = 4;
        panelComponents.add(textWord, gbc);
        
        gbc.gridy = 5; 
        panelComponents.add(label3, gbc); 
        
        gbc.gridy = 6; 
        panelComponents.add(label4, gbc); 
        
        gbc.gridy = 7; 
        panelComponents.add(label5, gbc); 
        
        gbc.gridy = 8;
        panelComponents.add(cbAdd, gbc);
        
        gbc.gridy = 9; 
        panelComponents.add(cbUpdate, gbc); 
        
        gbc.gridy = 10;
        panelComponents.add(cbDelete, gbc);
               
        panelComponents.revalidate();
        panelComponents.repaint();

    }
      
    
    private void addCustomeTable() {
    // Crear un modelo de tabla
    DefaultTableModel model = new DefaultTableModel();

    // Agregar columnas al modelo
    model.addColumn("ID");
    model.addColumn("Palabra");

    // Crear la tabla personalizada usando el modelo
    CustomeTable tableWords = new CustomeTable(
            model,                       // Modelo de la tabla
            new Dimension(300, 100000),  // Tamaño de la tabla
            Color.LIGHT_GRAY,            // Color por defecto
            Color.BLACK,                 // Color del texto
            new Color(173, 216, 230),    // Color de selección
            10                           // Radio de las esquinas
    );

    // Conectar a la base de datos y cargar datos
    dbConnection dbc = new dbConnection();
    ResultSet res = dbc.loadWords();

    try {
        while (res.next()) {
            int id = res.getInt("id_word");       // Obtén el ID de la palabra
            String word = res.getString("word"); // Obtén la palabra
            model.addRow(new Object[]{id, word}); // Agrega la fila al modelo
        }
    } catch (SQLException e) {
        System.out.println("Error al cargar datos: " + e.getMessage());
    }

    // Crear el JScrollPane para la tabla
    JScrollPane scrollPane = new JScrollPane(tableWords);
    scrollPane.setPreferredSize(new Dimension(300, 500));  // Tamaño de la vista del scroll

    // Ocultar las barras de desplazamiento
    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
    verticalScrollBar.setPreferredSize(new Dimension(0, 0));  // Ocultar la barra vertical

    JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
    horizontalScrollBar.setPreferredSize(new Dimension(0, 0));  // Ocultar la barra horizontal

    // Agregar el JScrollPane al panel
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.insets = new Insets(10, 15, 10, 0);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridy = 1;
    panelTable.add(scrollPane, gbc);

    // Actualizar el panel
    panelTable.revalidate();
    panelTable.repaint();
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelComponents = new javax.swing.JPanel();
        panelTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelComponents.setBackground(new java.awt.Color(66, 130, 170));
        panelComponents.setPreferredSize(new java.awt.Dimension(600, 600));
        panelComponents.setLayout(new java.awt.GridBagLayout());

        panelTable.setBackground(new java.awt.Color(47, 89, 114));
        panelTable.setPreferredSize(new java.awt.Dimension(400, 600));
        panelTable.setLayout(new java.awt.GridBagLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelComponents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelComponents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelTable;
    // End of variables declaration//GEN-END:variables
}
