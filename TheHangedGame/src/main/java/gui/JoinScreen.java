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

  // Declara una variable de tipo KeyEventDispatcher para manejar eventos de teclado.
private KeyEventDispatcher escKeyDispatcher;
// Declara una variable booleana para controlar si la tecla ESCAPE ha sido presionada.
private boolean isEscapePressed = false;

// Define el estilo de la fuente para las etiquetas (tipo "Doto", negrita, tamaño 20).
private Font labelFont = new Font("Doto", Font.BOLD, 20);
// Define el color del texto de las etiquetas como blanco.
private Color textColorLabel = Color.WHITE;

// Declara las variables para los campos de texto personalizados (nombre de usuario y código de juego).
private CustomeTextField textName;
private CustomeTextField textCode;

// Constructor de la clase JoinScreen.
public JoinScreen() {
    // Inicializa los componentes visuales de la pantalla (por ejemplo, botones, paneles, etc.).
    initComponents();
    // Establece que la tecla ESCAPE no ha sido presionada al principio.
    isEscapePressed = false;
    // Llama al método que añade un listener para la tecla ESCAPE.
    addEscKeyListener();
    // Llama al método que añade los campos de texto personalizados a la pantalla.
    addCustomeTextField();
    // Llama al método que añade la lista de jugadores a la pantalla.
    addCustomeList();
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
        // Crea un KeyEventDispatcher para manejar los eventos de teclas presionadas.
    escKeyDispatcher = new KeyEventDispatcher() {
        @Override
        // Método que se llama cada vez que se detecta un evento de teclado.
        public boolean dispatchKeyEvent(KeyEvent e) {
            // Si la tecla presionada es ESCAPE, se ejecuta abrirVentanaAnterior().
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                abrirVentanaAnterior(); // Llama a abrirVentanaAnterior.
                return true; // Indica que el evento fue manejado.
            }
            // Si la tecla presionada es ENTER, se ejecuta startGame().
            else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                startGame(); // Llama a startGame.
            }
            // Si la tecla no es ESCAPE ni ENTER, retorna false indicando que no se manejó el evento.
            return false;
            }
        };

         // Registra el KeyEventDispatcher para escuchar los eventos de teclado en el foco actual.
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher);
    }
    private void startGame() {
       // Obtiene los valores de los campos de texto (nombre de jugador e IP del juego).
    String playerName = textName.getText();
    String ip = textCode.getText();

    // Crea una nueva instancia de GameScreen con los valores obtenidos.
    GameScreen gs = new GameScreen(playerName, null, null, null, "Join", ip);

    // Hace visible la ventana GameScreen.
    gs.setVisible(true);
    // Centra la ventana en la pantalla.
    gs.setLocationRelativeTo(null);

    // Imprime un mensaje en la consola.
    System.out.println("HOLA");
    }
    
    private void abrirVentanaAnterior() {
          // Verifica si la tecla ESCAPE ya fue presionada para evitar múltiples ejecuciones.
    if (isEscapePressed) {
        return; // Si ya se presionó, no hace nada.
    }

    // Marca que la tecla ESCAPE ha sido presionada.
    isEscapePressed = true;

    // Elimina el KeyEventDispatcher para que la tecla ESCAPE ya no tenga efecto.
    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);

    // Llama al método estático para cerrar todas las ventanas abiertas.
    CloseAllWindows.cerrarTodasLasVentanas();

    // Crea una nueva instancia de JoinOrCreate.
    JoinOrCreate joc = new JoinOrCreate();

    // Hace visible la ventana JoinOrCreate.
    joc.setVisible(true);
    // Centra la ventana en la pantalla.
    joc.setLocationRelativeTo(null);

    // Cierra la ventana actual.
    this.dispose();
    }
    
      
    private void addCustomeTextField() {
       // Define las propiedades para el campo de texto (columnas, tamaño, colores, etc.).
    int columns = 20;
    Dimension textFieldSize = new Dimension(250, 40);
    Color defaultColor = new Color(255, 255, 255);
    Color focusColor = new Color(200, 230, 250);
    Color textColor = Color.BLACK;
    Color hoverColor = new Color(100, 200, 250);
    int radius = 15;

    // Crea las etiquetas y campos de texto personalizados.
    JLabel label1 = new JLabel("USER NAME: ");
    textName = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
    label1.setFont(labelFont); // Establece el estilo de la fuente para la etiqueta.
    label1.setForeground(textColorLabel); // Establece el color del texto de la etiqueta.

    JLabel label2 = new JLabel("CODE GAME: ");
    textCode = new CustomeTextField(columns, textFieldSize, defaultColor, focusColor, textColor, hoverColor, radius);
    label2.setFont(labelFont); // Establece el estilo de la fuente para la etiqueta.
    label2.setForeground(textColorLabel); // Establece el color del texto de la etiqueta.

    // Define el layout de GridBag para organizar los componentes.
    GridBagConstraints gbcCt = new GridBagConstraints();
    gbcCt.gridx = 0; // Establece la posición en la columna 0.
    gbcCt.insets = new Insets(10, 15, 10, 0); // Añade un margen de 10 píxeles en la parte superior e izquierda.
    gbcCt.anchor = GridBagConstraints.WEST; // Alinea los componentes a la izquierda.

    // Establece las posiciones de las etiquetas y campos de texto en el layout.
    gbcCt.gridy = 0;
    panelComponents.add(label1, gbcCt);

    gbcCt.gridy = 1;
    panelComponents.add(textName, gbcCt);

    gbcCt.gridy = 2;
    panelComponents.add(label2, gbcCt);

    gbcCt.gridy = 3;
    panelComponents.add(textCode, gbcCt);

    // Revalida y repinta el panel para que los componentes sean visibles.
    panelComponents.revalidate();
    panelComponents.repaint();
    }
    
    private void addCustomeList() {
       // Crea un modelo de lista con algunos jugadores predefinidos.
    DefaultListModel<String> model = new DefaultListModel<>();
    model.addElement("Player 1");
    model.addElement("Player 2");
    model.addElement("Player 3");
    model.addElement("Player 4");

    // Define el tamaño y colores de la lista.
    Dimension listSize = new Dimension(250, 200);
    Color defaultColor = new Color(255, 255, 255);
    Color textColor = Color.BLACK;
    int borderRadius = 20;
        
          // Crea una etiqueta y una lista personalizada con los jugadores.
    JLabel label3 = new JLabel("PLAYERS ");
    CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);
    label3.setFont(labelFont); // Establece el estilo de la fuente para la etiqueta.
    label3.setForeground(textColorLabel); // Establece el color del texto de la etiqueta.

    // Define el layout de GridBag para organizar la lista.
    GridBagConstraints gbcCl = new GridBagConstraints();
    gbcCl.gridx = 0; // Establece la posición en la columna 0.
    gbcCl.insets = new Insets(10, 15, 10, 0); // Añade un margen de 10 píxeles en la parte superior e izquierda.
    gbcCl.anchor = GridBagConstraints.WEST; // Alinea los componentes a la izquierda.

    // Establece las posiciones de la etiqueta y la lista en el layout.
    gbcCl.gridy = 4;
    panelComponents.add(label3, gbcCl);

    gbcCl.gridy = 5;
    panelComponents.add(customeList, gbcCl);

    // Revalida y repinta el panel para que los componentes sean visibles.
    panelComponents.revalidate();
    panelComponents.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelInfo;
    // End of variables declaration//GEN-END:variables
}
