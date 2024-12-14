// Declara el paquete al que pertenece la clase.
package customeComponents;

// Importa las bibliotecas necesarias para trabajar con tablas y sus propiedades.
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// Define una clase personalizada que extiende JTable.
public class CustomeTable extends JTable {
    // Variables para personalizar colores y diseño.
    private Color defaultColor; // Color de fondo de la tabla.
    private Color selectionColor; // Color para filas seleccionadas.
    private Color textColor; // Color del texto.

    // Constructor que inicializa la tabla con los valores proporcionados.
    public CustomeTable(DefaultTableModel model, Dimension size, Color defaultColor, Color textColor, Color selectionColor, int borderRadius) {
        super(model); // Llama al constructor de JTable con el modelo proporcionado.

        // Inicializa las propiedades con los valores recibidos.
        this.defaultColor = defaultColor;
        this.textColor = textColor;
        this.selectionColor = selectionColor;

        // Configura las propiedades visuales de la tabla.
        setOpaque(false); // Hace que el fondo sea transparente.
        setSelectionBackground(selectionColor); // Color de fondo al seleccionar una celda.
        setSelectionForeground(textColor); // Color del texto al seleccionar una celda.
        setGridColor(defaultColor.darker()); // Color de las líneas de la cuadrícula.
        setFont(new Font("Arial", Font.PLAIN, 14)); // Aplica una fuente personalizada.
        setRowHeight(30); // Define una altura fija para las filas.
        setPreferredSize(size); // Establece el tamaño preferido de la tabla.

        // Configura un renderizador personalizado para las celdas.
        setDefaultRenderer(Object.class, new CustomCellRenderer(borderRadius));

        // Elimina el borde predeterminado de la tabla.
        setBorder(BorderFactory.createEmptyBorder());
    }

    // Sobrescribe el método para personalizar cómo se pinta el componente.
    @Override
    protected void paintComponent(Graphics g) {
        // Crea un objeto Graphics2D para permitir un diseño más avanzado.
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Habilita el antialiasing.

        // Dibuja un rectángulo redondeado como fondo.
        g2.setColor(defaultColor); // Establece el color de fondo.
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Dibuja un fondo redondeado.

        // Llama al método original para pintar el contenido de la tabla.
        super.paintComponent(g2);

        // Libera los recursos del objeto Graphics2D.
        g2.dispose();
    }

    // Clase interna para un renderizador personalizado de celdas.
    private static class CustomCellRenderer extends DefaultTableCellRenderer {
        private final int borderRadius; // Radio de los bordes redondeados para las celdas.

        // Constructor que recibe el radio de los bordes.
        public CustomCellRenderer(int borderRadius) {
            this.borderRadius = borderRadius;
        }

        // Sobrescribe el método para personalizar el renderizado de celdas.
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            // Obtiene el componente base para la celda.
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Personaliza los colores dependiendo de si la celda está seleccionada.
            if (isSelected) {
                cell.setBackground(new Color(173, 216, 230)); // Azul claro para celdas seleccionadas.
                cell.setForeground(Color.BLACK); // Texto negro para celdas seleccionadas.
            } else {
                cell.setBackground(table.getBackground()); // Fondo por defecto.
                cell.setForeground(table.getForeground()); // Texto por defecto.
            }

            return cell; // Devuelve el componente personalizado.
        }
    }
}
