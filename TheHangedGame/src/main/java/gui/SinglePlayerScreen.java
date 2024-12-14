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

    // Constructor de la clase SinglePlayerScreen, que se ejecuta cuando se crea una nueva instancia de esta pantalla.
public SinglePlayerScreen() {
    // Inicializa los componentes gráficos de la ventana (botones, campos de texto, etc.).
    initComponents();
    
    // Inicializa la variable isEscapePressed como false, lo que indica que no se ha presionado la tecla ESCAPE aún.
    isEscapePressed = false;
    
    // Llama al método addCustomeTextField() para agregar campos de texto personalizados a la pantalla.
    addCustomeTextField();
    
    // Llama al método addEscKeyListener() para agregar un escuchador de la tecla ESCAPE.
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

    // Método para agregar un escucha de la tecla ESC para poder cerrar la ventana y regresar a la pantalla anterior.
private void addEscKeyListener() {
    // Crear un KeyEventDispatcher que captura los eventos de teclado.
    escKeyDispatcher = new KeyEventDispatcher() {
        @Override
        // Método que captura los eventos de tecla.
        public boolean dispatchKeyEvent(KeyEvent e) {
            // Verifica si se ha presionado la tecla ESCAPE.
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // Si se presiona ESCAPE, se llama al método para abrir la ventana anterior.
                abrirVentanaAnterior();
                return true; // Indica que el evento ha sido manejado.
            }
            return false; // Si no es ESCAPE, el evento no se maneja.
        }
    };

    // Agrega el KeyEventDispatcher al manejador de eventos de teclado.
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher);
}

// Método que maneja la acción de abrir la ventana anterior.
private void abrirVentanaAnterior() {
    // Si ya se ha presionado ESCAPE, no hacer nada más.
    if (isEscapePressed) {
        return;
    }
    
    // Marca que ESCAPE ya ha sido presionada para evitar múltiples acciones.
    isEscapePressed = true;
    
    // Remueve el KeyEventDispatcher que escucha la tecla ESCAPE.
    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
    
    // Cierra todas las ventanas abiertas.
    CloseAllWindows.cerrarTodasLasVentanas();
    
    // Crea una nueva instancia de la pantalla principal (HomeScreen).
    HomeScreen hs = new HomeScreen();
               
    // Hace visible la ventana y la centra en la pantalla.
    hs.setVisible(true);
    hs.setLocationRelativeTo(null);

    // Cierra la ventana actual.
    this.dispose();
}

// Método para agregar campos de texto personalizados a la pantalla.
private void addCustomeTextField() {
    // Definición de las propiedades de los campos de texto.
    int columns = 20; // Número de columnas del campo de texto.
    Dimension textFieldSize = new Dimension(250, 40); // Tamaño del campo de texto.
    Color defaultColor = new Color(255, 255, 255); // Color de fondo del campo de texto.
    Color focusColor = new Color(200, 230, 250); // Color cuando el campo de texto está enfocado.
    Color textColor = Color.BLACK; // Color del texto.
    Color hoverColor = new Color(100, 200, 250); // Color al pasar el mouse sobre el campo.
    int radius = 15; // Radio de las esquinas del campo de texto para redondearlas.
    
    // Definición de la fuente de las etiquetas.
    Font labelFont = new Font("Doto", Font.BOLD, 20);

    // Creación de las etiquetas y campos de texto personalizados.
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
    
    // Llama a otro método que añade el botón de inicio con los valores de los campos de texto.
    addCustomeButton(textName, textRounds, textTime, textWordsCant);
    
    JLabel label5 = new JLabel(" "); // Un espacio en blanco al final de los campos.

    // Usa GridBagConstraints para colocar las etiquetas y campos de texto en el panel.
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0; // Columna donde se coloca el componente.
    gbc.insets = new Insets(10, 15, 10, 0); // Márgenes alrededor del componente.
    gbc.anchor = GridBagConstraints.WEST; // Alinea los componentes a la izquierda.

    // Añade las etiquetas y campos de texto al panel en diferentes filas.
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

    // Revalidación y repintado del panel para reflejar los cambios.
    panelComponents.revalidate();
    panelComponents.repaint();
}

// Método para agregar el botón de inicio del juego.
private void addCustomeButton(CustomeTextField textName, CustomeTextField textRounds, CustomeTextField textTime, CustomeTextField textWordsCant) {
    // Define el tamaño del botón y los colores.
    Dimension buttonSize = new Dimension(250, 50);
    Color colorBtnSingle = new Color(33, 77, 103);
    Color hoverBtnSingle = new Color(56, 182, 255);
    Color pressedColorBtnSingle = new Color(33, 77, 103);
    
    // Crea el botón de inicio de juego.
    CustomeButton cbsp = new CustomeButton("START GAME", buttonSize, colorBtnSingle, hoverBtnSingle, pressedColorBtnSingle);

    // Añade un ActionListener al botón para iniciar el juego cuando se presione.
    cbsp.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtiene los valores de los campos de texto.
            String playerName = textName.getText().trim();
            String rounds = textRounds.getText().trim();
            String timeWords = textTime.getText().trim();
            String wordsCant = textWordsCant.getText().trim();
            
            // Crea una nueva instancia de la pantalla del juego.
            GameScreen gs = new GameScreen(playerName, rounds, timeWords, wordsCant, "", "");
            
            // Hace visible la pantalla del juego y la centra en la pantalla.
            gs.setVisible(true);
            gs.setLocationRelativeTo(null);
            
            // Cierra la ventana actual.
            dispose();
        }
    });

    // Usa GridBagConstraints para colocar el botón en el panel.
    GridBagConstraints gbcSingle = new GridBagConstraints();
    gbcSingle.gridx = 0;
    gbcSingle.gridy = 9; // Fila donde se coloca el botón.
    gbcSingle.insets = new Insets(10, 10, 10, 10); // Márgenes alrededor del botón.
    gbcSingle.anchor = GridBagConstraints.CENTER; // Centra el botón en el espacio disponible.

    // Añade el botón al panel y actualiza el panel.
    panelComponents.add(cbsp, gbcSingle);
    panelComponents.revalidate();
    panelComponents.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelImage;
    // End of variables declaration//GEN-END:variables
}
