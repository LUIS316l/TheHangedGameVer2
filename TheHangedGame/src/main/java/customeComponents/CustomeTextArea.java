package customeComponents;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CustomeTextArea extends JTextArea {
    private Color defaultColor;
    private Color textColor;
    private int borderRadius;

    public CustomeTextArea(String text, Dimension size, Color defaultColor, Color textColor, int borderRadius) {
        super(text);

        this.defaultColor = defaultColor;
        this.textColor = textColor;
        this.borderRadius = borderRadius;

        setOpaque(false); 
        setForeground(textColor); 
        setFont(new Font("Arial", Font.PLAIN, 14)); 
        setWrapStyleWord(true); 
        setLineWrap(true); 
        setBorder(new EmptyBorder(10, 10, 10, 10)); 
        setPreferredSize(size);
        setEditable(false); 
        setFocusable(false);
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
