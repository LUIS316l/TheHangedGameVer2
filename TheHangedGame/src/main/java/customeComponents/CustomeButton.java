// Declara el paquete de la clase.
package customeComponents;

// Importa las bibliotecas necesarias para el componente personalizado.
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Define una clase personalizada para un botón con estilos.
public class CustomeButton extends JButton {

    // Colores para los diferentes estados del botón.
    private Color defaultColor;
    private Color hoverColor;
    private Color pressedColor;

    // Constructor para configurar el botón personalizado.
    public CustomeButton(String text, Dimension size, Color defaultColor, Color hoverColor, Color pressedColor) {
        super(text); // Llama al constructor de la clase JButton con el texto del botón.

        // Inicializa los colores del botón.
        this.defaultColor = defaultColor;
        this.hoverColor = hoverColor;
        this.pressedColor = pressedColor;

        // Configura las propiedades visuales del botón.
        setContentAreaFilled(false); // Desactiva el área de contenido por defecto.
        setForeground(Color.WHITE); // Establece el color del texto en blanco.
        setFont(new Font("Arial", Font.BOLD, 14)); // Aplica una fuente específica al texto.
        setOpaque(false); // Hace que el fondo sea transparente.
        setBorderPainted(false); // Elimina el borde predeterminado.
        setFocusPainted(false); // Desactiva el borde de enfoque.
        setPreferredSize(size); // Define el tamaño preferido del botón.
        setBackground(defaultColor); // Establece el color de fondo inicial.

        // Agrega un MouseListener para manejar eventos del ratón.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor); // Cambia el color cuando se presiona el botón.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(defaultColor); // Restaura el color al soltar el botón.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor); // Cambia el color al pasar el ratón sobre el botón.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(defaultColor); // Restaura el color al salir del botón.
            }
        });
    }

    // Sobrescribe el método para pintar el componente.
    @Override
    protected void paintComponent(Graphics g) {
        // Crea un objeto Graphics2D para dibujar con antialiasing.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Aplica el color de fondo según el estado del botón.
        if (getModel().isPressed()) {
            g2.setColor(pressedColor); // Color cuando está presionado.
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor); // Color cuando el ratón está sobre el botón.
        } else {
            g2.setColor(defaultColor); // Color por defecto.
        }

        // Dibuja un botón con bordes redondeados.
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Llama al método original para pintar el texto.
        super.paintComponent(g2);

        // Libera recursos del objeto Graphics2D.
        g2.dispose();
    }

    // Sobrescribe el método para evitar pintar un borde.
    @Override
    protected void paintBorder(Graphics g) {
        // No hace nada para evitar el dibujo del borde.
    }
}
