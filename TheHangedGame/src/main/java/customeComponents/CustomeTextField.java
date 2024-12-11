package customeComponents;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CustomeTextField extends JTextField {
    private Color defaultColor;
    private Color focusColor;
    private Color textColor;
    private Color hoverColor;
    private int cornerRadius;

    public CustomeTextField(int columns, Dimension size, Color defaultColor, Color focusColor, Color textColor, Color hoverColor, int cornerRadius) {
        super(columns);
        this.defaultColor = defaultColor;
        this.focusColor = focusColor;
        this.textColor = textColor;
        this.hoverColor = hoverColor;
        this.cornerRadius = cornerRadius;

        setOpaque(false); 
        setForeground(textColor); 
        setFont(new Font("Arial", Font.PLAIN, 14));
        setPreferredSize(size);
        setBorder(new EmptyBorder(5, 10, 5, 10)); 
        setBackground(defaultColor);
        
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(focusColor); // Cambiar al color de foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(defaultColor); // Volver al color por defecto cuando pierde el foco
            }
        });
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!hasFocus()) {
                    setBackground(hoverColor); // Cambiar al color de hover
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!hasFocus()) {
                    setBackground(defaultColor); // Volver al color por defecto al salir del hover
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (isFocusOwner()) {
            g2.setColor(focusColor);
        } else {
            g2.setColor(defaultColor);
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // No dibujar borde predeterminado
    }
}
