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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ADMscreen extends javax.swing.JFrame {
    
    private KeyEventDispatcher escKeyDispatcher;
    private boolean isEscapePressed = false;
    private DefaultTableModel model;

    private CustomeTextField textID;
    private CustomeTextField textWord;
    
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
        textID = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label1.setFont(labelFont);
         
        JLabel label2 = new JLabel("PALABRA: ");
        textWord = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
        label2.setFont(labelFont);
        
        JLabel label3 = new JLabel(" ");
        JLabel label4 = new JLabel(" ");
        JLabel label5 = new JLabel(" ");

        
        CustomeButton cbAdd = new CustomeButton("AGREGAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);
        
        cbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wordText = textWord.getText().trim();

                if (!wordText.isEmpty()) {
                    Connection con = dbConnection.conectar();
                    if (con != null) {
                        try {
                            // Verificar si la palabra ya existe
                            String checkQuery = "SELECT id_word FROM words WHERE word = ?";
                            try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                                checkStmt.setString(1, wordText);
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // La palabra ya existe
                                    JOptionPane.showMessageDialog(null, 
                                        "La palabra ya existe con el ID: " + rs.getInt("id_word"), 
                                        "Información", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                    return;
                                }
                            }

                            // Generar automáticamente el nuevo ID
                            String idQuery = "SELECT COALESCE(MAX(id_word), 0) + 1 AS new_id FROM words";
                            int newId = 0;
                            try (PreparedStatement idStmt = con.prepareStatement(idQuery)) {
                                ResultSet rs = idStmt.executeQuery();
                                if (rs.next()) {
                                    newId = rs.getInt("new_id");
                                }
                            }

                            // Insertar la nueva palabra
                            String insertQuery = "INSERT INTO words (id_word, word) VALUES (?, ?)";
                            try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
                                insertStmt.setInt(1, newId);
                                insertStmt.setString(2, wordText);
                                int rowsInserted = insertStmt.executeUpdate();
                                if (rowsInserted > 0) {
                                    JOptionPane.showMessageDialog(null, 
                                        "Palabra agregada correctamente con ID: " + newId, 
                                        "Éxito", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                    textWord.setText("");
                                    reloadTableData();
                                } else {
                                    JOptionPane.showMessageDialog(null, 
                                        "No se pudo agregar la palabra.", 
                                        "Error", 
                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, 
                                "Error al agregar la palabra: " + ex.getMessage(), 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        } finally {
                            try {
                                con.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Por favor, ingresa una palabra.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
        CustomeButton cbUpdate= new CustomeButton("MODIFICAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);
                
        cbUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = textID.getText().trim();
                String wordText = textWord.getText().trim();

                if (!idText.isEmpty() && !wordText.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idText);

                        Connection con = dbConnection.conectar();
                        if (con != null) {
                            // Verificar si el ID existe
                            String checkQuery = "SELECT * FROM words WHERE id_word = ?";
                            try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                                checkStmt.setInt(1, id);
                                ResultSet rs = checkStmt.executeQuery();

                                if (rs.next()) {
                                    // Actualizar la palabra
                                    String updateQuery = "UPDATE words SET word = ? WHERE id_word = ?";
                                    try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
                                        updateStmt.setString(1, wordText);
                                        updateStmt.setInt(2, id);

                                        int rowsUpdated = updateStmt.executeUpdate();
                                        if (rowsUpdated > 0) {
                                            JOptionPane.showMessageDialog(null, "Palabra actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                            textID.setText("");
                                            textWord.setText("");
                                            reloadTableData();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "No se pudo actualizar la palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "El ID no existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al modificar la palabra: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        
        CustomeButton cbDelete = new CustomeButton("ELIMINAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);

        cbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = textID.getText().trim();
                String wordText = textWord.getText().trim();

                if (!idText.isEmpty() || !wordText.isEmpty()) {
                    Connection con = dbConnection.conectar();
                    if (con != null) {
                        try {
                            String checkQuery;
                            PreparedStatement checkStmt;

                            if (!idText.isEmpty()) {
                                // Verificar si existe la palabra por ID
                                checkQuery = "SELECT word FROM words WHERE id_word = ?";
                                checkStmt = con.prepareStatement(checkQuery);
                                checkStmt.setInt(1, Integer.parseInt(idText));
                            } else {
                                // Verificar si existe la palabra por texto
                                checkQuery = "SELECT id_word FROM words WHERE word = ?";
                                checkStmt = con.prepareStatement(checkQuery);
                                checkStmt.setString(1, wordText);
                            }

                            ResultSet rs = checkStmt.executeQuery();
                            if (rs.next()) {
                                String confirmationMessage;
                                if (!idText.isEmpty()) {
                                    confirmationMessage = "¿Estás seguro de que deseas eliminar la palabra con ID " 
                                        + idText + "?";
                                } else {
                                    confirmationMessage = "¿Estás seguro de que deseas eliminar la palabra \"" 
                                        + wordText + "\"?";
                                }

                                int confirm = JOptionPane.showConfirmDialog(null, 
                                    confirmationMessage, 
                                    "Confirmar eliminación", 
                                    JOptionPane.YES_NO_OPTION);

                                if (confirm == JOptionPane.YES_OPTION) {
                                    // Eliminar la palabra
                                    String deleteQuery;
                                    PreparedStatement deleteStmt;

                                    if (!idText.isEmpty()) {
                                        deleteQuery = "DELETE FROM words WHERE id_word = ?";
                                        deleteStmt = con.prepareStatement(deleteQuery);
                                        deleteStmt.setInt(1, Integer.parseInt(idText));
                                    } else {
                                        deleteQuery = "DELETE FROM words WHERE word = ?";
                                        deleteStmt = con.prepareStatement(deleteQuery);
                                        deleteStmt.setString(1, wordText);
                                    }

                                    int rowsDeleted = deleteStmt.executeUpdate();
                                    if (rowsDeleted > 0) {
                                        JOptionPane.showMessageDialog(null, 
                                            "Palabra eliminada correctamente.", 
                                            "Éxito", 
                                            JOptionPane.INFORMATION_MESSAGE);
                                        textID.setText("");
                                        textWord.setText("");
                                        reloadTableData();
                                    } else {
                                        JOptionPane.showMessageDialog(null, 
                                            "No se pudo eliminar la palabra.", 
                                            "Error", 
                                            JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, 
                                    "La palabra o el ID no existen en la base de datos.", 
                                    "Advertencia", 
                                    JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, 
                                "Error al eliminar la palabra: " + ex.getMessage(), 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, 
                                "El ID debe ser un número válido.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        } finally {
                            try {
                                con.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, 
                        "Por favor, ingresa el ID o la palabra que deseas eliminar.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
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
        model = new DefaultTableModel();

        model.addColumn("ID");
        model.addColumn("Palabra");

        CustomeTable tableWords = new CustomeTable(
                model,                       // Modelo de la tabla
                new Dimension(300, 100000),  // Tamaño de la tabla
                Color.LIGHT_GRAY,            // Color por defecto
                Color.BLACK,                 // Color del texto
                new Color(173, 216, 230),    // Color de selección
                10                           // Radio de las esquinas
        );

        dbConnection dbc = new dbConnection();
        ResultSet res = dbc.loadWords();

        try {
            while (res.next()) {
                int id = res.getInt("id_word");       
                String word = res.getString("word");
                model.addRow(new Object[]{id, word});           
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }

        reloadTableData();
        
        JScrollPane scrollPane = new JScrollPane(tableWords);
        scrollPane.setPreferredSize(new Dimension(300, 500)); 

        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setPreferredSize(new Dimension(0, 0));  

        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setPreferredSize(new Dimension(0, 0));  

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(10, 15, 10, 0);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy = 1;
        panelTable.add(scrollPane, gbc);

        panelTable.revalidate();
        panelTable.repaint();
        
        tableWords.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableWords.getSelectedRow();
                if (selectedRow != -1) { // Verificar que haya una fila seleccionada
                    String id = model.getValueAt(selectedRow, 0).toString();
                    String word = model.getValueAt(selectedRow, 1).toString();

                    textID.setText(id);
                    textWord.setText(word);
                }
            }
        });
    }

    private void reloadTableData() {
        model.setRowCount(0); // Limpiar los datos existentes

        dbConnection dbc = new dbConnection();
        ResultSet res = dbc.loadWords();

        try {
            while (res.next()) {
                int id = res.getInt("id_word");
                String word = res.getString("word");
                model.addRow(new Object[]{id, word});
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
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
