// Declara el paquete al que pertenece la clase.
package customeComponents;

// Importa las bibliotecas necesarias para crear y personalizar el componente.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

// Define una clase personalizada que extiende JList.
public class CustomeList<E> extends JList<E> {

    // Variables para personalizar colores y el radio de bordes redondeados.
    private Color defaultColor; // Color de fondo.
    private Color textColor; // Color del texto.
    private int borderRadius; // Radio de los bordes redondeados.

    // Constructor que inicializa el componente con los valores proporcionados.
    public CustomeList(DefaultListModel<E> model, Dimension size, Color defaultColor, Color textColor, int borderRadius) {
        super(model); // Llama al constructor de JList con el modelo proporcionado.

        // Inicializa las propiedades con los valores recibidos.
        this.defaultColor = defaultColor;
        this.textColor = textColor;
        this.borderRadius = borderRadius;

        // Configura las propiedades visuales del componente.
        setOpaque(false); // Hace que el fondo sea transparente.
        setSelectionBackground(defaultColor); // Establece el color de fondo cuando un elemento está seleccionado.
        setSelectionForeground(textColor); // Establece el color del texto cuando un elemento está seleccionado.
        setForeground(textColor); // Establece el color del texto por defecto.
        setFont(new Font("Arial", Font.PLAIN, 14)); // Aplica una fuente personalizada.
        setFixedCellHeight(30); // Define la altura fija de las celdas.
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Agrega un margen interno.
        setPreferredSize(size); // Define el tamaño preferido de la lista.

        // Desactiva el enfoque y la habilitación del componente.
        setFocusable(false); // Evita que el componente reciba foco.
        setEnabled(false); // Desactiva la interacción con la lista.
    }

    // Sobrescribe el método para personalizar cómo se pinta el componente.
    @Override
    protected void paintComponent(Graphics g) {
        // Crea un objeto Graphics2D para dibujar con características avanzadas.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Habilita el antialiasing para bordes suaves.

        // Dibuja un rectángulo redondeado como fondo.
        g2.setColor(defaultColor); // Usa el color de fondo.
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius); // Dibuja el fondo con bordes redondeados.

        // Llama al método original para pintar los elementos de la lista.
        super.paintComponent(g2);

        // Libera recursos del objeto Graphics2D.
        g2.dispose();
    }

    // Sobrescribe el método para evitar pintar un borde alrededor de la lista.
    @Override
    protected void paintBorder(Graphics g) {
        // Deja vacío este método para no pintar un borde por defecto.
    }
}
