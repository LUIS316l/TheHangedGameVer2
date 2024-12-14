package gui;
//librerias
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

import utils.CloseAllWindows;

public class CreateScreen extends javax.swing.JFrame {

    private KeyEventDispatcher escKeyDispatcher; //maneja la accion de presioonar la tecla esc
    private boolean isEscapePressed = false; // Indica si la tecla ESC fue presionada.
        
 private CustomeTextField textName;          // Campo para ingresar el nombre del jugador.
private CustomeTextField textRounds;        // Campo para ingresar el número de rondas.
private CustomeTextField textTimeWord;      // Campo para ingresar el tiempo por palabra.
private CustomeTextField textWordsCant;     // Campo para ingresar la cantidad de palabras.
private CustomeTextField textCodeGame;      // Campo para mostrar la IP del servidor.
    
 private Font labelFont = new Font("Doto", Font.BOLD, 20); // Fuente de las etiquetas.
private Color textColorLabel = Color.WHITE;              // Color del texto de las etiquetas.
     
    public CreateScreen() {
      initComponents();           // Inicializa los componentes gráficos.
    isEscapePressed = false;    // Inicializa la variable de control de ESC.
    addEscKeyListener();        // Agrega el detector de la tecla ESC.
    addCustomeTextField();      // Crea y agrega campos de texto personalizados.
    IPAddress();                // Obtiene y muestra la IP local.
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
                   abrirVentanaAnterior();  // Abre la ventana anterior si se presiona ESC.
                     return true;             // Indica que el evento fue manejado.
                }
                return false;  // No se manejó el evento
            }
        };
        
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher); // Agrega el detector de eventos al administrador de enfoque.
    }
        
    private void abrirVentanaAnterior() {
        if (isEscapePressed) {
            return;   // Evita ejecutar el método más de una vez.
    }

    isEscapePressed = true;  // Marca que se presionó ESC.

    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);  
    // Elimina el detector de eventos.

    CloseAllWindows.cerrarTodasLasVentanas();  
    // Cierra todas las ventanas abiertas.

    JoinOrCreate joc = new JoinOrCreate();  
    // Crea una nueva ventana para unirse o crear una partida.

    joc.setVisible(true);           // Muestra la nueva ventana.
    joc.setLocationRelativeTo(null);  // Centra la ventana en la pantalla.

    this.dispose();  // Cierra la ventana actual.
    }
    
    
    private void addCustomeTextField() {
       int columns = 20;                            // Número de columnas en los campos de texto.
    Dimension textFieldSize = new Dimension(250, 40);  // Tamaño de los campos de texto.
    Color defaultColor = new Color(255, 255, 255);      // Color de fondo por defecto.
    Color focusColor = new Color(200, 230, 250);        // Color de fondo al enfocar.
    Color textColor = Color.BLACK;                     // Color del texto.
    Color hoverColor = new Color(100, 200, 250);       // Color al pasar el mouse.
    int radius = 15;                                   // Radio de bordes redondeados.
               
    //**************************etiquetas y sus caracteristicas****************************************//
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
        gbcCt.insets = new Insets(10, 15, 10, 0); //MARGENES 
        gbcCt.anchor = GridBagConstraints.WEST; //ALINEA A LA IZQUIERDA

        gbcCt.gridy = 0;
        panelComponents.add(label1, gbcCt);//AGREGA KA ETIQUETA NOMBRE 

        gbcCt.gridy = 1; 
        panelComponents.add(textName, gbcCt); //AGREGA EL CAMPO DE TEXTO

        gbcCt.gridy = 2;
        panelComponents.add(label2, gbcCt); //AGREGA LA ETIQUETA DE RONDAS 

        gbcCt.gridy = 3;
        panelComponents.add(textRounds, gbcCt); //AGREGA EL CAMPO DE TEXTO 
        
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

      panelComponents.revalidate();  // Actualiza la interfaz.
      panelComponents.repaint();     // Redibuja la interfaz.
    }
    
    private void addCustomeList(CustomeTextField textName, CustomeTextField textRounds, CustomeTextField textTimeWord, CustomeTextField textWordsCant ) {
        Dimension buttonSize = new Dimension(250, 50);  // Tamaño del botón.
Color   colorBtnJoin = new Color(33, 77, 103);    // Color por defecto del botón.
Color   hoverBtnJoin = new Color(56, 182, 255);   // Color al pasar el mouse.
Color   pressedColorBtnJoin = new Color(33, 77, 103);  // Color al presionar el botón.
        
        CustomeButton cbCs = new CustomeButton("INICIAR PARTIDA", buttonSize, colorBtnJoin, hoverBtnJoin, pressedColorBtnJoin);
        
        cbCs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            String name = textName.getText().trim();        // Obtiene el nombre ingresado.
            String rounds = textRounds.getText().trim();    // Obtiene las rondas.
            String timeWords = textTimeWord.getText().trim();  // Obtiene el tiempo por palabra.
            String wordsCant = textWordsCant.getText().trim(); // Obtiene la cantidad de palabras.
                            
            GameScreen gs = new GameScreen(name, rounds, timeWords, wordsCant, "Create", "");
                 // Crea una nueva pantalla de juego con la información ingresada.

            gs.setVisible(true);         // Muestra la nueva ventana.
            gs.setLocationRelativeTo(null);  // Centra la ventana.
        
            dispose();  // Cierra la ventana actual.
            }        
        });
        //LISTA DE JUGADORES 
      // Crea un modelo para la lista, que es un contenedor para los elementos de la lista
DefaultListModel<String> model = new DefaultListModel<>();

// Agrega elementos al modelo de la lista (en este caso, nombres de jugadores)
model.addElement("Player 1");
model.addElement("Player 2");
model.addElement("Player 3");
model.addElement("Player 4");
model.addElement("Player 5");

// Define el tamaño de la lista (ancho de 250 y alto de 200)
Dimension listSize = new Dimension(250, 200);

// Establece el color de fondo de la lista como blanco
Color defaultColor = new Color(255, 255, 255);

// Define el color del texto dentro de la lista (negro)
Color textColor = Color.BLACK;

// Establece el radio de bordes redondeados de la lista
int borderRadius = 20;

// Crea una etiqueta (JLabel) para mostrar el texto "JUGADORES"
JLabel label3 = new JLabel("JUGADORES ");

// Crea una instancia personalizada de una lista (CustomeList) utilizando el modelo, el tamaño, el color de fondo, el color del texto y el radio de borde
CustomeList<String> customeList = new CustomeList<>(model, listSize, defaultColor, textColor, borderRadius);

// Establece la fuente de la etiqueta 'label3'
label3.setFont(labelFont);

// Establece el color del texto de la etiqueta 'label3'
label3.setForeground(textColorLabel);

// Crea etiquetas vacías para espacio en blanco (posiblemente se usan para agregar espacio entre los componentes)
JLabel label4 = new JLabel("");
JLabel label5 = new JLabel("");
JLabel label6 = new JLabel("");

// Configura las restricciones de diseño para colocar los componentes en el panel (panelList)
GridBagConstraints gbc = new GridBagConstraints();

// Establece la posición del componente en la primera columna (0) y define el espacio interno alrededor del componente
gbc.gridx = 0;
gbc.insets = new Insets(10, 15, 10, 0);
gbc.anchor = GridBagConstraints.WEST;

// Coloca la etiqueta 'label3' en la fila 4
gbc.gridy = 4;
panelList.add(label3, gbc); 

// Coloca la lista personalizada 'customeList' en la fila 5
gbc.gridy = 5;
panelList.add(customeList, gbc); 

// Coloca una etiqueta vacía en la fila 6
gbc.gridy = 6;
panelList.add(label4, gbc);

// Coloca una etiqueta vacía en la fila 7
gbc.gridy = 7;
panelList.add(label5, gbc);

// Coloca una etiqueta vacía en la fila 8
gbc.gridy = 8;
panelList.add(label6, gbc);

// Coloca el botón cbCs en la fila 9
gbc.gridy = 9;
panelList.add(cbCs, gbc);

// Coloca el botón cbCs nuevamente en la fila 10 (probablemente esto es un error, ya que se coloca dos veces el mismo botón)
gbc.gridy = 10;
panelList.add(cbCs, gbc);

// Realiza una actualización en el panel para reflejar los cambios (se asegura de que los componentes se agreguen correctamente)
panelList.revalidate();

// Redibuja el panel para que los cambios se muestren en la interfaz gráfica
panelList.repaint();
    }

    private void IPAddress() { 
      try {
        InetAddress ip = InetAddress.getLocalHost();  // Obtiene la IP local.
        String host = ip.getHostAddress();            // Extrae la dirección IP.
        textCodeGame.setText(host);                  // Muestra la IP en el campo.
    } catch (UnknownHostException e) {
        System.out.println("No se pudo obtener la IP: " + e.getMessage());  
        // Maneja la excepción si ocurre un error.
    }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelComponents;
    private javax.swing.JPanel panelList;
    // End of variables declaration//GEN-END:variables
}
