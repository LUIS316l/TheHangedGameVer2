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
    
    private KeyEventDispatcher escKeyDispatcher;  // Variable para escuchar eventos del teclado
    private boolean isEscapePressed = false;  // Bandera para verificar si la tecla Escape ya fue presionada
    private DefaultTableModel model;  // Modelo de tabla (no usado en este fragmento)

    private CustomeTextField textID;  // Campo de texto personalizado para ID (no usado aquí)
    private CustomeTextField textWord;  // Campo de texto personalizado para palabra (no usado aquí)
    
    public ADMscreen() {
        initComponents();  // Inicializa los componentes de la interfaz
        isEscapePressed = false;  // Asegura que la tecla Escape no haya sido presionada
        addCustomeButtons();  // Agrega botones personalizados (no implementado aquí)
        addCustomeTable();  // Agrega la tabla personalizada (no implementado aquí)
        addEscKeyListener();  // Agrega el listener para la tecla Escape
    }

    // Método para agregar el listener de la tecla Escape
    private void addEscKeyListener() {
        escKeyDispatcher = new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                // Verifica si la tecla presionada es Escape
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    abrirVentanaSiguiente();  // Llama al método para cambiar de ventana
                    return true;
                }
                return false; 
            }
        };

        // Registra el KeyEventDispatcher para escuchar las teclas presionadas
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher);
    }
        
    // Método que abre la siguiente ventana al presionar Escape
    private void abrirVentanaSiguiente() {
        if (isEscapePressed) {  // Si ya se presionó Escape, no hacer nada
            return;
        }
        
        isEscapePressed = true;  // Marca que la tecla Escape ya fue presionada
        
        // Elimina el KeyEventDispatcher para no seguir escuchando la tecla Escape
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
        
        CloseAllWindows.cerrarTodasLasVentanas();  // Cierra todas las ventanas abiertas
        
        HomeScreen hs = new HomeScreen();  // Crea una nueva instancia de la ventana HomeScreen
                   

        hs.setVisible(true);  // Muestra la ventana HomeScreen
        hs.setLocationRelativeTo(null);  // Centra la ventana en la pantalla

        this.dispose();  // Cierra la ventana actual (ADMscreen)
    }
    
    private void addCustomeButtons() {
        // Se definen los tamaños y colores para los botones y campos de texto
        Dimension buttonSize = new Dimension(250, 50);  // Tamaño del botón
        Color colorBtnSingle = new Color(33, 77, 103);  // Color normal del botón
        Color hoverBtnSingle = new Color(56, 182, 255);  // Color del botón cuando se pasa el mouse sobre él
        Color pressedColorBtnSingle = new Color(33, 77, 103);  // Color cuando el botón es presionado

        // Definición de los campos de texto (tamaño y colores)
        int columns = 20;  // Número de columnas para el campo de texto
        Dimension textFieldSize = new Dimension(250, 40);  // Tamaño del campo de texto
        Color defaultColor = new Color(255, 255, 255);  // Color de fondo por defecto del campo de texto
        Color focusColor = new Color(200, 230, 250);  // Color cuando el campo de texto está enfocado
        Color textColor = Color.BLACK;  // Color del texto dentro del campo
        Color hoverColor = new Color(100, 200, 250);  // Color cuando el campo de texto tiene el foco
        int radius = 15;  // Radio de las esquinas del campo de texto (para bordes redondeados)

        // Se define la fuente para las etiquetas
        Font labelFont = new Font("Doto", Font.BOLD, 20);

        // Se crean las etiquetas e instancias de los campos de texto
        JLabel label1 = new JLabel("ID: ");  // Etiqueta para el campo de ID
        textID = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);  // Campo de texto para ID
        label1.setFont(labelFont);  // Se establece la fuente para la etiqueta

        JLabel label2 = new JLabel("PALABRA: ");  // Etiqueta para el campo de palabra
        textWord = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);  // Campo de texto para palabra
        label2.setFont(labelFont);  // Se establece la fuente para la etiqueta

        // Se crean etiquetas vacías para usarlas como espacio (se pueden usar para alineación)
        JLabel label3 = new JLabel(" ");  // Etiqueta vacía
        JLabel label4 = new JLabel(" ");  // Etiqueta vacía
        JLabel label5 = new JLabel(" ");  // Etiqueta vacía
        
        // Se crea un botón personalizado "AGREGAR" con tamaño y colores definidos previamente
        CustomeButton cbAdd = new CustomeButton("AGREGAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);

        // Se agrega un ActionListener al botón
        cbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el texto ingresado en el campo de palabra y eliminar espacios al inicio y final
                String wordText = textWord.getText().trim();

                // Verificar si el campo de palabra no está vacío
                if (!wordText.isEmpty()) {
                    // Establecer conexión a la base de datos
                    Connection con = dbConnection.conectar();
                    if (con != null) {
                        try {
                            // Verificar si la palabra ya existe en la base de datos
                            String checkQuery = "SELECT id_word FROM words WHERE word = ?";
                            try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                                checkStmt.setString(1, wordText);  // Establecer la palabra en el preparedStatement
                                ResultSet rs = checkStmt.executeQuery();
                                if (rs.next()) {
                                    // Si la palabra ya existe, mostrar un mensaje con el ID
                                    JOptionPane.showMessageDialog(null, 
                                        "La palabra ya existe con el ID: " + rs.getInt("id_word"), 
                                        "Información", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                    return;  // Salir de la acción
                                }
                            }

                            // Obtener el nuevo ID generando automáticamente el siguiente valor
                            String idQuery = "SELECT COALESCE(MAX(id_word), 0) + 1 AS new_id FROM words";
                            int newId = 0;
                            try (PreparedStatement idStmt = con.prepareStatement(idQuery)) {
                                ResultSet rs = idStmt.executeQuery();
                                if (rs.next()) {
                                    newId = rs.getInt("new_id");
                                }
                            }

                            // Insertar la nueva palabra en la base de datos
                            String insertQuery = "INSERT INTO words (id_word, word) VALUES (?, ?)";
                            try (PreparedStatement insertStmt = con.prepareStatement(insertQuery)) {
                                insertStmt.setInt(1, newId);  // Establecer el nuevo ID
                                insertStmt.setString(2, wordText);  // Establecer la palabra
                                int rowsInserted = insertStmt.executeUpdate();  // Ejecutar la inserción
                                if (rowsInserted > 0) {
                                    // Si la inserción fue exitosa, mostrar un mensaje y limpiar el campo de texto
                                    JOptionPane.showMessageDialog(null, 
                                        "Palabra agregada correctamente con ID: " + newId, 
                                        "Éxito", 
                                        JOptionPane.INFORMATION_MESSAGE);
                                    textWord.setText("");  // Limpiar el campo de texto
                                    reloadTableData();  // Recargar los datos de la tabla
                                } else {
                                    // Si no se pudo insertar la palabra, mostrar un mensaje de error
                                    JOptionPane.showMessageDialog(null, 
                                        "No se pudo agregar la palabra.", 
                                        "Error", 
                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (SQLException ex) {
                            // Si ocurre un error al interactuar con la base de datos, mostrar un mensaje de error
                            JOptionPane.showMessageDialog(null, 
                                "Error al agregar la palabra: " + ex.getMessage(), 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();  // Mostrar el error en consola
                        } finally {
                            // Cerrar la conexión a la base de datos, si está abierta
                            try {
                                con.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();  // Mostrar error en consola si no se puede cerrar la conexión
                            }
                        }
                    }
                } else {
                    // Si el campo de palabra está vacío, mostrar una advertencia
                    JOptionPane.showMessageDialog(null, 
                        "Por favor, ingresa una palabra.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
        // Se crea un botón personalizado "MODIFICAR" con tamaño y colores definidos previamente
        CustomeButton cbUpdate = new CustomeButton("MODIFICAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);

        // Se agrega un ActionListener al botón
        cbUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los textos ingresados en los campos ID y palabra, eliminando espacios al inicio y final
                String idText = textID.getText().trim();
                String wordText = textWord.getText().trim();

                // Verificar que ambos campos no estén vacíos
                if (!idText.isEmpty() && !wordText.isEmpty()) {
                    try {
                        // Convertir el texto del ID a un número entero
                        int id = Integer.parseInt(idText);

                        // Establecer conexión a la base de datos
                        Connection con = dbConnection.conectar();
                        if (con != null) {
                            // Verificar si el ID existe en la base de datos
                            String checkQuery = "SELECT * FROM words WHERE id_word = ?";
                            try (PreparedStatement checkStmt = con.prepareStatement(checkQuery)) {
                                checkStmt.setInt(1, id);  // Establecer el ID en el preparedStatement
                                ResultSet rs = checkStmt.executeQuery();

                                if (rs.next()) {
                                    // Si el ID existe, proceder con la actualización de la palabra
                                    String updateQuery = "UPDATE words SET word = ? WHERE id_word = ?";
                                    try (PreparedStatement updateStmt = con.prepareStatement(updateQuery)) {
                                        updateStmt.setString(1, wordText);  // Establecer la nueva palabra
                                        updateStmt.setInt(2, id);  // Establecer el ID para la actualización

                                        // Ejecutar la actualización
                                        int rowsUpdated = updateStmt.executeUpdate();
                                        if (rowsUpdated > 0) {
                                            // Si la actualización fue exitosa, mostrar mensaje de éxito
                                            JOptionPane.showMessageDialog(null, "Palabra actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                                            textID.setText("");  // Limpiar el campo de ID
                                            textWord.setText("");  // Limpiar el campo de palabra
                                            reloadTableData();  // Recargar los datos de la tabla
                                        } else {
                                            // Si no se pudo actualizar, mostrar mensaje de error
                                            JOptionPane.showMessageDialog(null, "No se pudo actualizar la palabra.", "Error", JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } else {
                                    // Si el ID no existe, mostrar mensaje de advertencia
                                    JOptionPane.showMessageDialog(null, "El ID no existe.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    } catch (NumberFormatException ex) {
                        // Si el ID no es un número válido, mostrar mensaje de error
                        JOptionPane.showMessageDialog(null, "El ID debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException ex) {
                        // Si ocurre un error de SQL, mostrar el mensaje de error correspondiente
                        JOptionPane.showMessageDialog(null, "Error al modificar la palabra: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();  // Mostrar el error en consola
                    }
                } else {
                    // Si algún campo está vacío, mostrar advertencia
                    JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        
        // Se crea un botón personalizado "ELIMINAR" con tamaño y colores definidos previamente
        CustomeButton cbDelete = new CustomeButton("ELIMINAR", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);

        // Se agrega un ActionListener al botón
        cbDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los textos ingresados en los campos ID y palabra, eliminando espacios al inicio y final
                String idText = textID.getText().trim();
                String wordText = textWord.getText().trim();

                // Verificar que al menos uno de los campos no esté vacío
                if (!idText.isEmpty() || !wordText.isEmpty()) {
                    // Establecer conexión a la base de datos
                    Connection con = dbConnection.conectar();
                    if (con != null) {
                        try {
                            String checkQuery;
                            PreparedStatement checkStmt;

                            // Verificar si se proporcionó un ID o una palabra
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
                                // Si existe la palabra, solicitar confirmación para eliminarla
                                String confirmationMessage;
                                if (!idText.isEmpty()) {
                                    confirmationMessage = "¿Estás seguro de que deseas eliminar la palabra con ID " 
                                        + idText + "?";
                                } else {
                                    confirmationMessage = "¿Estás seguro de que deseas eliminar la palabra \"" 
                                        + wordText + "\"?";
                                }

                                // Mostrar cuadro de confirmación
                                int confirm = JOptionPane.showConfirmDialog(null, 
                                    confirmationMessage, 
                                    "Confirmar eliminación", 
                                    JOptionPane.YES_NO_OPTION);

                                if (confirm == JOptionPane.YES_OPTION) {
                                    // Si se confirma, proceder a eliminar la palabra
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
                                        // Si la eliminación fue exitosa, mostrar mensaje de éxito
                                        JOptionPane.showMessageDialog(null, 
                                            "Palabra eliminada correctamente.", 
                                            "Éxito", 
                                            JOptionPane.INFORMATION_MESSAGE);
                                        textID.setText("");  // Limpiar el campo de ID
                                        textWord.setText("");  // Limpiar el campo de palabra
                                        reloadTableData();  // Recargar los datos de la tabla
                                    } else {
                                        // Si no se pudo eliminar, mostrar mensaje de error
                                        JOptionPane.showMessageDialog(null, 
                                            "No se pudo eliminar la palabra.", 
                                            "Error", 
                                            JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else {
                                // Si el ID o la palabra no existe, mostrar mensaje de advertencia
                                JOptionPane.showMessageDialog(null, 
                                    "La palabra o el ID no existen en la base de datos.", 
                                    "Advertencia", 
                                    JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            // Si ocurre un error de SQL, mostrar el mensaje de error correspondiente
                            JOptionPane.showMessageDialog(null, 
                                "Error al eliminar la palabra: " + ex.getMessage(), 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                            ex.printStackTrace();  // Mostrar el error en consola
                        } catch (NumberFormatException ex) {
                            // Si el ID no es un número válido, mostrar mensaje de error
                            JOptionPane.showMessageDialog(null, 
                                "El ID debe ser un número válido.", 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                        } finally {
                            // Asegurarse de cerrar la conexión, independientemente de si hubo error o no
                            try {
                                con.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                } else {
                    // Si ambos campos están vacíos, mostrar advertencia
                    JOptionPane.showMessageDialog(null, 
                        "Por favor, ingresa el ID o la palabra que deseas eliminar.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
         
        // Se crea un objeto GridBagConstraints para controlar la disposición de los componentes en el panel.
        GridBagConstraints gbc = new GridBagConstraints();

        // Se establece el valor de la columna (columna 0) donde se colocarán los componentes.
        gbc.gridx = 0;

        // Se definen los márgenes para los componentes (10 píxeles en todos los lados).
        gbc.insets = new Insets(10, 10, 10, 10);

        // Se establece que los componentes estarán centrados dentro de su celda en la cuadrícula.
        gbc.anchor = GridBagConstraints.CENTER;

        // Se comienza con la primera fila para el primer componente (label1).
        gbc.gridy = 1;
        panelComponents.add(label1, gbc);

        // En la siguiente fila, se coloca el componente textID.
        gbc.gridy = 2;
        panelComponents.add(textID, gbc);

        // Se coloca label2 en la siguiente fila.
        gbc.gridy = 3;
        panelComponents.add(label2, gbc);

        // Se coloca textWord en la siguiente fila.
        gbc.gridy = 4;
        panelComponents.add(textWord, gbc);

        // Se coloca label3 en la siguiente fila.
        gbc.gridy = 5;
        panelComponents.add(label3, gbc);

        // Se coloca label4 en la siguiente fila.
        gbc.gridy = 6;
        panelComponents.add(label4, gbc);

        // Se coloca label5 en la siguiente fila.
        gbc.gridy = 7;
        panelComponents.add(label5, gbc);

        // Se coloca el botón cbAdd en la fila siguiente (fila 8).
        gbc.gridy = 8;
        panelComponents.add(cbAdd, gbc);

        // Se coloca el botón cbUpdate en la fila 9.
        gbc.gridy = 9;
        panelComponents.add(cbUpdate, gbc);

        // Se coloca el botón cbDelete en la fila 10.
        gbc.gridy = 10;
        panelComponents.add(cbDelete, gbc);

        // Se revalidan y repintan los componentes en el panel para asegurarse de que se muestren correctamente después de realizar las modificaciones.
        panelComponents.revalidate();
        panelComponents.repaint();
    }     
      
      
    
   // Método para añadir la tabla personalizada
    private void addCustomeTable() {
        // Crear el modelo de la tabla y definir las columnas
        model = new DefaultTableModel();
        model.addColumn("ID");  // Columna para el ID
        model.addColumn("Palabra");  // Columna para la palabra

        // Crear una instancia de CustomeTable con el modelo definido
        CustomeTable tableWords = new CustomeTable(
                model,                       // Modelo de la tabla
                new Dimension(300, 100000),  // Tamaño de la tabla
                Color.LIGHT_GRAY,            // Color por defecto
                Color.BLACK,                 // Color del texto
                new Color(173, 216, 230),    // Color de selección
                10                           // Radio de las esquinas
        );

        // Crear una instancia de la conexión a la base de datos
        dbConnection dbc = new dbConnection();
        // Cargar las palabras desde la base de datos
        ResultSet res = dbc.loadWords();

        try {
            // Recorrer los resultados y agregar cada fila al modelo de la tabla
            while (res.next()) {
                int id = res.getInt("id_word");  // Obtener el ID
                String word = res.getString("word");  // Obtener la palabra
                model.addRow(new Object[]{id, word});  // Agregar la fila a la tabla
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());  // Manejo de error al cargar datos
        }

        // Recargar los datos de la tabla (asegura que los datos se actualicen)
        reloadTableData();

        // Crear un JScrollPane para permitir el desplazamiento de la tabla
        JScrollPane scrollPane = new JScrollPane(tableWords);
        scrollPane.setPreferredSize(new Dimension(300, 500));  // Establecer tamaño del scroll

        // Personalizar las barras de desplazamiento (hacerlas invisibles)
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setPreferredSize(new Dimension(0, 0));  // Barra de desplazamiento vertical invisible

        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();
        horizontalScrollBar.setPreferredSize(new Dimension(0, 0));  // Barra de desplazamiento horizontal invisible

        // Configurar las restricciones de GridBag para agregar el JScrollPane al panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;  // Columna 0
        gbc.insets = new Insets(10, 15, 10, 0);  // Márgenes
        gbc.anchor = GridBagConstraints.WEST;  // Alinear a la izquierda
        gbc.gridy = 1;  // Fila 1
        panelTable.add(scrollPane, gbc);  // Añadir el scrollPane al panel

        // Actualizar el panel
        panelTable.revalidate();
        panelTable.repaint();

        // Agregar un MouseListener a la tabla para seleccionar filas
        tableWords.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tableWords.getSelectedRow();  // Obtener la fila seleccionada
                if (selectedRow != -1) {  // Verificar que haya una fila seleccionada
                    String id = model.getValueAt(selectedRow, 0).toString();  // Obtener el ID
                    String word = model.getValueAt(selectedRow, 1).toString();  // Obtener la palabra

                    // Establecer el texto de los campos de entrada
                    textID.setText(id);
                    textWord.setText(word);
                }
            }
        });
    }

    // Método para recargar los datos de la tabla
    private void reloadTableData() {
        model.setRowCount(0);  // Limpiar los datos existentes en la tabla

        // Crear una nueva instancia de conexión a la base de datos
        dbConnection dbc = new dbConnection();
        // Cargar nuevamente las palabras desde la base de datos
        ResultSet res = dbc.loadWords();

        try {
            // Recorrer los resultados y agregar cada fila al modelo de la tabla
            while (res.next()) {
                int id = res.getInt("id_word");  // Obtener el ID
                String word = res.getString("word");  // Obtener la palabra
                model.addRow(new Object[]{id, word});  // Agregar la fila a la tabla
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());  // Manejo de error al cargar datos
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
