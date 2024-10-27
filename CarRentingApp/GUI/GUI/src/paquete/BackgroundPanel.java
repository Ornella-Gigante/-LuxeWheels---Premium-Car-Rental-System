package paquete;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Panel personalizado para mostrar la imagen de fondo
 */
class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel() {
        try {
            // URL de la imagen de fondo (reemplaza con la URL que desees usar)
            URL imageUrl = new URL("https://img.freepik.com/free-photo/luxury-car-parked-highway-with-modern-buildings-sunset_181624-60607.jpg");
            backgroundImage = new ImageIcon(imageUrl).getImage();
        } catch (Exception e) {
            e.printStackTrace();
            // Imagen de respaldo en caso de error
            backgroundImage = new ImageIcon(getClass().getResource("/resources/default-background.jpg")).getImage();
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}