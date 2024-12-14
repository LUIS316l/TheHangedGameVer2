// Declara el paquete al que pertenece la clase.
package customeComponents;

// Importa las bibliotecas necesarias para crear el componente personalizado.
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

// Define una clase personalizada para un botón estilizado que extiende JButton.
public class CustomeButtonInfo extends JButton {

    // Colores para representar los diferentes estados del botón.
    private Color defaultColor;
    private Color hoverColor;
    private Color pressedColor;

    // Constructor que inicializa las propiedades del botón.
    public CustomeButtonInfo(String text, Dimension size, Color defaultColor, Color hoverColor, Color pressedColor) {
        super(text); // Llama al constructor de JButton con el texto para el botón.

        // Asigna los colores proporcionados a las variables de estado.
        this.defaultColor = defaultColor;
        this.hoverColor = hoverColor;
        this.pressedColor = pressedColor;

        // Configura las propiedades visuales y de interacción del botón.
        setContentAreaFilled(false); // Elimina el área de contenido predeterminada.
        setForeground(Color.WHITE); // Establece el color del texto a blanco.
        setFont(new Font("Arial", Font.BOLD, 14)); // Aplica una fuente personalizada al texto.
        setOpaque(false); // Hace que el fondo del botón sea transparente.
        setBorderPainted(false); // Desactiva la pintura del borde predeterminado.
        setFocusPainted(false); // Elimina la visualización del borde de enfoque.
        setPreferredSize(size); // Establece el tamaño preferido del botón.
        setBackground(defaultColor); // Establece el color inicial de fondo del botón.

        // Agrega un MouseListener para manejar los eventos del ratón.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedColor); // Cambia el color al presionar el botón.
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

    // Sobrescribe el método para personalizar cómo se pinta el componente.
    @Override
    protected void paintComponent(Graphics g) {
        // Crea un objeto Graphics2D para dibujar con características avanzadas.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Habilita el antialiasing para bordes suaves.

        // Cambia el color del botón según su estado.
        if (getModel().isPressed()) {
            g2.setColor(pressedColor); // Color cuando está presionado.
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor); // Color cuando el ratón está sobre el botón.
        } else {
            g2.setColor(defaultColor); // Color por defecto.
        }

        // Dibuja un rectángulo redondeado como fondo del botón.
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);

        // Llama al método original para pintar el texto.
        super.paintComponent(g2);

        // Libera recursos del objeto Graphics2D.
        g2.dispose();
    }

    // Sobrescribe el método para evitar que se pinte un borde.
    @Override
    protected void paintBorder(Graphics g) {
        // Deja el método vacío para no pintar un borde alrededor del botón.
    }
}
