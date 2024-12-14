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
    // Verifica si la instancia es nula o si la ventana actual no está visible.
    if (instance == null || !instance.isDisplayable()) {
        // Si la instancia es nula o no está visible, crea una nueva instancia de JoinOrCreate.
        instance = new JoinOrCreate();
        }
     // Retorna la instancia de JoinOrCreate (ya sea la nueva o la existente).
        return instance;
    }
    
    private void addEscKeyListener() {
         // Crea un KeyEventDispatcher para manejar los eventos de teclas presionadas.
    escKeyDispatcher = new KeyEventDispatcher() {
        @Override
        // Método que se llama cada vez que se detecta una tecla presionada.
        public boolean dispatchKeyEvent(KeyEvent e) {
            // Verifica si la tecla presionada es la tecla ESCAPE.
            if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                // Si es la tecla ESCAPE, ejecuta abrirVentanaAnterior() y retorna true para indicar que el evento fue manejado.
                abrirVentanaAnterior();
                return true;
            }
            // Si no es la tecla ESCAPE, retorna false, indicando que el evento no fue manejado.
            return false;
            }
        };
 // Registra el KeyEventDispatcher para escuchar los eventos de teclado en el foco actual.
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(escKeyDispatcher);
    }
    
    @Override
    public void dispose() {
       // Cuando se llama a dispose, libera la referencia de la instancia de JoinOrCreate para que no quede en memoria.
    instance = null;
    // Llama al método dispose de la superclase para asegurarse de liberar recursos asociados con la ventana.
    super.dispose();
    }

    
    private void abrirVentanaAnterior() {
        // Verifica si la tecla ESCAPE ya fue presionada para evitar múltiples ejecuciones.
    if (isEscapePressed) {
        return; // Si ya se presionó, no hace nada.
    }
    
    // Marca que la tecla ESCAPE ha sido presionada para evitar que se ejecute más de una vez.
    isEscapePressed = true;
    
    // Elimina el KeyEventDispatcher para que la tecla ESCAPE ya no tenga efecto.
    KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
    
    // Llama al método estático cerrarTodasLasVentanas() para cerrar todas las ventanas abiertas.
    CloseAllWindows.cerrarTodasLasVentanas();
    
    // Crea una nueva instancia de HomeScreen (pantalla principal).
    HomeScreen hs = new HomeScreen();
    
    // Hace visible la ventana de HomeScreen.
    hs.setVisible(true);
    // Centra la ventana en la pantalla.
    hs.setLocationRelativeTo(null);

    // Llama al método dispose() para cerrar la ventana actual.
    dispose();
    }
    
    private void addCustomeButton() {
        // Define las dimensiones de los botones personalizados.
    Dimension buttonSize = new Dimension(250, 50);

    // Define los colores para el botón "JOIN GAME" y sus efectos (normal, hover, presionado).
    Color colorBtnJoin = new Color(33, 77, 103);
    Color hoverBtnJoin = new Color(56, 182, 255);
    Color pressedColorBtnJoin = new Color(33, 77, 103);
    
    // Define los colores para el botón "CREATE GAME" y sus efectos (normal, hover, presionado).
    Color colorBtnCreate = new Color(66, 120, 170);
    Color hoverBtnCreate = new Color(56, 182, 255);
    Color pressedColorBtnCreate = new Color(66, 120, 170);
    
    // Crea el botón "JOIN GAME" con los colores definidos y el tamaño de botón especificado.
    CustomeButton cbjg = new CustomeButton("JOIN GAME", buttonSize, colorBtnJoin, hoverBtnJoin, pressedColorBtnJoin);
    // Crea el botón "CREATE GAME" con los colores definidos y el tamaño de botón especificado.
    CustomeButton cbcg = new CustomeButton("CREATE GAME", buttonSize, colorBtnCreate, hoverBtnCreate, pressedColorBtnCreate);
    
    // Añade un ActionListener al botón "JOIN GAME" que se ejecutará cuando el botón sea presionado.
    cbjg.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Crea una nueva instancia de JoinScreen (pantalla para unirse a un juego).
            JoinScreen js = new JoinScreen();
            
            // Hace visible la ventana JoinScreen.
            js.setVisible(true);
            // Centra la ventana en la pantalla.
            js.setLocationRelativeTo(null);
            
            // Elimina el KeyEventDispatcher para que la tecla ESCAPE ya no tenga efecto.
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
            
            // Cierra la ventana actual.
            dispose();
        }
    });
    
    // Añade un ActionListener al botón "CREATE GAME" que se ejecutará cuando el botón sea presionado.
    cbcg.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Crea una nueva instancia de CreateScreen (pantalla para crear un juego).
            CreateScreen cs = new CreateScreen();
            
            // Hace visible la ventana CreateScreen.
            cs.setVisible(true);
            // Centra la ventana en la pantalla.
            cs.setLocationRelativeTo(null);
            
            // Elimina el KeyEventDispatcher para que la tecla ESCAPE ya no tenga efecto.
            KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(escKeyDispatcher);
            
            // Cierra la ventana actual.
            dispose();
            }        
        });
        
       // Crea un objeto GridBagConstraints para configurar la posición y márgenes de los botones en el layout.
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;  // Establece la posición en la columna 0.
    gbc.gridy = 0;  // Establece la posición en la fila 0.
    gbc.insets = new Insets(10, 10, 10, 10);  // Añade un margen de 10 píxeles a todos los lados.
    gbc.anchor = GridBagConstraints.CENTER;  // Centra el botón en el espacio disponible.
    
    // Añade el botón "JOIN GAME" al panel 'panelJoin' con las restricciones de GridBag.
    panelJoin.add(cbjg, gbc);
    // Revalidar y repintar el panel para asegurarse de que el nuevo botón sea visible.
    panelJoin.revalidate();
    panelJoin.repaint();
    
    // Añade el botón "CREATE GAME" al panel 'panelCreate' con las restricciones de GridBag.
    panelCreate.add(cbcg, gbc);
    // Revalidar y repintar el panel para asegurarse de que el nuevo botón sea visible.
    panelCreate.revalidate();
    panelCreate.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelCreate;
    private javax.swing.JPanel panelJoin;
    // End of variables declaration//GEN-END:variables
}
