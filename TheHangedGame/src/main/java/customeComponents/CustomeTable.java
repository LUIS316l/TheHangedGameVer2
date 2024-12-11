package customeComponents;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomeTable extends JTable {
    private Color defaultColor;
    private Color selectionColor;
    private Color textColor;

    public CustomeTable(DefaultTableModel model, Dimension size, Color defaultColor, Color textColor, Color selectionColor, int borderRadius) {
        super(model);

        this.defaultColor = defaultColor;
        this.textColor = textColor;
        this.selectionColor = selectionColor;

        setOpaque(false);
        setSelectionBackground(selectionColor);
        setSelectionForeground(textColor);
        setGridColor(defaultColor.darker()); // Color de las líneas de la tabla
        setFont(new Font("Arial", Font.PLAIN, 14));
        setRowHeight(30); // Altura fija de las filas
        setPreferredSize(size);

        // Renderizador personalizado para el diseño de celdas
        setDefaultRenderer(Object.class, new CustomCellRenderer(borderRadius));

        // Eliminar borde predeterminado
        setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo de la tabla
        g2.setColor(defaultColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

        super.paintComponent(g2);

        g2.dispose();
    }

    // Renderizador para las celdas de la tabla
    private static class CustomCellRenderer extends DefaultTableCellRenderer {
        private final int borderRadius;

        public CustomCellRenderer(int borderRadius) {
            this.borderRadius = borderRadius;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (isSelected) {
                cell.setBackground(new Color(173, 216, 230)); // Azul claro
                cell.setForeground(Color.BLACK); // Texto negro para la selección
            } else {
                cell.setBackground(table.getBackground());
                cell.setForeground(table.getForeground());
            }

            return cell;
        }
    }
}
