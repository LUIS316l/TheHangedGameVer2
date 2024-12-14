// Declara el paquete al que pertenece la clase.
package customeComponents;

// Importa las bibliotecas necesarias para trabajar con tablas y sus propiedades.
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomeTextField extends JTextField {
    private Color defaultColor;  // Color de fondo por defecto
    private Color focusColor;    // Color cuando el campo tiene el foco
    private Color textColor;     // Color del texto
    private Color hoverColor;    // Color cuando el cursor pasa sobre el campo
    private int cornerRadius;    // Radio para bordes redondeados

    // Constructor que inicializa el campo de texto con colores y características personalizadas
    public CustomeTextField(int columns, Dimension size, Color defaultColor, Color focusColor, Color textColor, Color hoverColor, int cornerRadius) {
        super(columns);  // Llama al constructor de JTextField con el número de columnas

        this.defaultColor = defaultColor;
        this.focusColor = focusColor;
        this.textColor = textColor;
        this.hoverColor = hoverColor;
        this.cornerRadius = cornerRadius;

        setOpaque(false);  // Hace que el fondo del campo de texto sea transparente
        setForeground(textColor);  // Establece el color del texto
        setFont(new Font("Arial", Font.PLAIN, 14));  // Define la fuente del texto
        setPreferredSize(size);  // Establece el tamaño preferido del campo
        setBorder(new EmptyBorder(5, 10, 5, 10));  // Establece los márgenes internos
        setBackground(defaultColor);  // Establece el color de fondo por defecto

        // Agrega un Listener para detectar cuando el campo gana o pierde el foco
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(focusColor); // Cambia al color de foco cuando el campo recibe el foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(defaultColor); // Vuelve al color por defecto cuando el campo pierde el foco
            }
        });
        
        // Agrega un Listener para detectar cuando el ratón pasa sobre el campo
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!hasFocus()) {
                    setBackground(hoverColor); // Cambia al color de hover cuando el ratón entra, si el campo no tiene foco
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!hasFocus()) {
                    setBackground(defaultColor); // Vuelve al color por defecto cuando el ratón sale
                }
            }
        });
    }

    // Método para pintar el componente (dibuja el fondo redondeado)
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();  // Crea un objeto Graphics2D para dibujar
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  // Mejora la calidad del dibujo

        // Si el campo tiene el foco, se usa el color de foco, si no, se usa el color por defecto
        if (isFocusOwner()) {
            g2.setColor(focusColor);
        } else {
            g2.setColor(defaultColor);
        }

        // Dibuja el fondo redondeado con el color correspondiente
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g2);  // Llama al método de la clase base para pintar el texto

        g2.dispose();  // Libera los recursos gráficos
    }

    // Método para no dibujar el borde predeterminado
    @Override
    protected void paintBorder(Graphics g) {
        // No dibuja el borde predeterminado
    }
}
