package paquete;

import javax.swing.*;
import java.awt.*;

public class Goodbye {
    private JFrame frame;

    public Goodbye() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Gracias");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);

        JLabel thankYouLabel = new JLabel("¡MUCHAS GRACIAS POR SU COMPRA!");
        thankYouLabel.setForeground(new Color(255, 255, 255));
        thankYouLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thankYouLabel.setFont(new Font("Arial", Font.BOLD, 30));
        thankYouLabel.setBounds(0, 200, 800, 40);
        mainPanel.add(thankYouLabel);

        JLabel goodTripLabel = new JLabel("¡BUEN VIAJE!");
        goodTripLabel.setForeground(new Color(255, 255, 255));
        goodTripLabel.setHorizontalAlignment(SwingConstants.CENTER);
        goodTripLabel.setFont(new Font("Arial", Font.BOLD, 30));
        goodTripLabel.setBounds(0, 250, 800, 40);
        mainPanel.add(goodTripLabel);
    }
}
