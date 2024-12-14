// Declara el paquete al que pertenece la clase.
package customeComponents;

// Importa las bibliotecas necesarias para trabajar con tablas y sus propiedades.
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomeTextArea extends JTextArea {
    private Color defaultColor;  // Color de fondo personalizado
    private Color textColor;     // Color del texto
    private int borderRadius;    // Radio de los bordes redondeados

    // Constructor de la clase
    public CustomeTextArea(String text, Dimension size, Color defaultColor, Color textColor, int borderRadius) {
        super(text);  // Llama al constructor de JTextArea con el texto proporcionado

        this.defaultColor = defaultColor;
        this.textColor = textColor;
        this.borderRadius = borderRadius;

        setOpaque(false);  // Hace que el fondo sea transparente
        setForeground(textColor);  // Establece el color del texto
        setFont(new Font("Arial", Font.PLAIN, 14));  // Define la fuente del texto
        setWrapStyleWord(true);  // Ajusta las palabras en lugar de solo caracteres
        setLineWrap(true);  // Hace que el texto se ajuste automáticamente a la línea
        setBorder(new EmptyBorder(10, 10, 10, 10));  // Añade un borde vacío (margen interno)
        setPreferredSize(size);  // Define el tamaño preferido del área de texto
        setEditable(false);  // Hace que el área de texto no sea editable
        setFocusable(false);  // Hace que el área de texto no reciba el foco
    }

    // Método para dibujar el componente
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();  // Crea un objeto Graphics2D para dibujar
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Mejora la calidad de los bordes

        g2.setColor(defaultColor);  // Establece el color de fondo
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);  // Dibuja un rectángulo con bordes redondeados

        super.paintComponent(g2);  // Llama al método de pintura de la clase base

        g2.dispose();  // Libera los recursos gráficos utilizados
    }

    // Método para no dibujar el borde por defecto
    @Override
    protected void paintBorder(Graphics g) {
        // No dibuja el borde predeterminado
    }
}
