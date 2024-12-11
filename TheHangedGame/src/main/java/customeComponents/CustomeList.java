package customeComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomeList<E> extends JList<E> {
    private Color defaultColor;
    private Color textColor;
    private int borderRadius;

    public CustomeList(DefaultListModel<E> model, Dimension size, Color defaultColor, Color textColor, int borderRadius) {
        super(model);

        this.defaultColor = defaultColor;
        this.textColor = textColor;
        this.borderRadius = borderRadius;

        setOpaque(false); 
        setSelectionBackground(defaultColor); 
        setSelectionForeground(textColor);
        setForeground(textColor); 
        setFont(new Font("Arial", Font.PLAIN, 14)); 
        setFixedCellHeight(30); 
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(size);

        setFocusable(false);
        setEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(defaultColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);

        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No dibujar borde por defecto
    }
}
