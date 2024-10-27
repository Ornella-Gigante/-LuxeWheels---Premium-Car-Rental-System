package paquete;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ChooseVehicle {
    private JFrame frame;
    private static final int NUM_VEHICLES = 4;
    private String selectedVehicleType;

    private String[] suvImages = {
        "https://img.freepik.com/free-photo/blue-jeep-parking-public-zone_114579-4042.jpg",
        "https://img.freepik.com/free-photo/black-luxury-sport-utility-vehicle-suv-driving-road_114579-5044.jpg",
        "https://img.freepik.com/free-photo/blue-sport-sedan-parked-yard_114579-5078.jpg",
        "https://img.freepik.com/premium-photo/red-modern-suv-car-outdoor_114579-5063.jpg"
    };

    private String[] suvNames = {
        "Jeep Azul", "SUV Negro", "SUV Azul", "SUV Negro"
    };
    
    private double[] suvPrices = {89.99, 94.99, 92.99, 96.99};
    private String[] suvDescriptions = {
        "4x4, 5 puertas, GPS, Bluetooth, Climatizador",
        "5 puertas, GPS, Cámara trasera, Techo panorámico",
        "7 plazas, GPS, Control de crucero, Sensor de parking",
        "5 puertas, Tracción total, GPS, Asientos calefactables"
    };

    private String[] sedanImages = {
        "https://img.freepik.com/free-photo/white-luxury-sedan-car-driving-road_114579-4005.jpg",
        "https://img.freepik.com/free-photo/grey-metallic-jeep-with-blue-stripe-it_114579-4080.jpg",
        "https://img.freepik.com/free-photo/blue-sport-sedan-parked-yard_114579-5078.jpg",
        "https://img.freepik.com/free-photo/silver-metallic-color-sport-sedan-road_114579-5035.jpg"
    };

    private String[] sedanNames = {
        "Sedán Blanco", "Sedán Gris", "Sedán Azul", "Sedán Plateado"
    };
    
    private double[] sedanPrices = {69.99, 72.99, 74.99, 76.99};
    private String[] sedanDescriptions = {
        "4 puertas, GPS, Control de crucero, Bluetooth",
        "5 puertas, GPS, Cámara trasera, Sensor de parking",
        "4 puertas, GPS, Asientos de cuero, Climatizador",
        "5 puertas, GPS, Sistema de sonido premium, Start/Stop"
    };

    private String[] deportivoImages = {
        "https://img.freepik.com/free-photo/red-luxury-sedan-road_114579-5079.jpg",
        "https://img.freepik.com/free-photo/yellow-sport-car-with-black-autotuning-road_114579-5051.jpg",
        "https://img.freepik.com/free-photo/blue-sport-car-highway_114579-4056.jpg",
        "https://img.freepik.com/free-photo/white-sport-car-with-red-stripes_114579-4066.jpg"
    };

    private String[] deportivoNames = {
        "Deportivo Rojo", "Deportivo Amarillo", "Deportivo Azul", "Deportivo Blanco"
    };
    
    private double[] deportivoPrices = {129.99, 134.99, 139.99, 144.99};
    private String[] deportivoDescriptions = {
        "2 puertas, GPS, 450CV, Cambio automático deportivo",
        "2 puertas, GPS, 500CV, Modo Sport Plus",
        "2 puertas, GPS, 480CV, Launch Control",
        "2 puertas, GPS, 520CV, Sistema de escape deportivo"
    };

    private String[] compactoImages = {
        "https://img.freepik.com/free-photo/metallic-blue-sedan-car_114579-4054.jpg",
        "https://img.freepik.com/free-photo/grey-metallic-sedan-driving-road_114579-4065.jpg",
        "https://img.freepik.com/free-photo/copper-orange-hatchback-family-car_114579-4031.jpg",
        "https://img.freepik.com/free-photo/white-hatchback-car-drives-road_114579-4045.jpg"
    };

    private String[] compactoNames = {
        "Compacto Azul", "Compacto Gris", "Compacto Naranja", "Compacto Blanco"
    };
    
    private double[] compactoPrices = {49.99, 52.99, 54.99, 56.99};
    private String[] compactoDescriptions = {
        "5 puertas, GPS, Bluetooth, Consumo eficiente",
        "3 puertas, GPS, Sistema Start/Stop",
        "5 puertas, GPS, Sensor de parking",
        "5 puertas, GPS, Control de crucero"
    };

    public ChooseVehicle(String vehicleType) {
        this.selectedVehicleType = vehicleType;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Selección de Vehículo - Alquiler de Coches");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(50, 63, 700, 500);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);

        JPanel vehiclesPanel = new JPanel();
        vehiclesPanel.setLayout(new BoxLayout(vehiclesPanel, BoxLayout.Y_AXIS));
        vehiclesPanel.setOpaque(false);

        String[] currentImages;
        String[] currentNames;
        double[] currentPrices;
        String[] currentDescriptions;

        switch (selectedVehicleType.toLowerCase()) {
            case "suv - todo terreno":
                currentImages = suvImages;
                currentNames = suvNames;
                currentPrices = suvPrices;
                currentDescriptions = suvDescriptions;
                break;
            case "sedán - familiar":
                currentImages = sedanImages;
                currentNames = sedanNames;
                currentPrices = sedanPrices;
                currentDescriptions = sedanDescriptions;
                break;
            case "deportivo":
                currentImages = deportivoImages;
                currentNames = deportivoNames;
                currentPrices = deportivoPrices;
                currentDescriptions = deportivoDescriptions;
                break;
            case "compacto":
                currentImages = compactoImages;
                currentNames = compactoNames;
                currentPrices = compactoPrices;
                currentDescriptions = compactoDescriptions;
                break;
            default:
                currentImages = suvImages;
                currentNames = suvNames;
                currentPrices = suvPrices;
                currentDescriptions = suvDescriptions;
                break;
        }

        for (int i = 0; i < NUM_VEHICLES; i++) {
            JPanel vehiclePanel = createVehiclePanel(i, currentImages[i], currentNames[i], 
                                                   currentPrices[i], currentDescriptions[i]);
            vehiclesPanel.add(vehiclePanel);
            vehiclesPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        }

        JScrollPane scrollPane = new JScrollPane(vehiclesPanel);
        scrollPane.setBounds(25, 80, 650, 400);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        contentPanel.add(scrollPane);

        JLabel titleLabel = new JLabel("VEHÍCULOS DISPONIBLES - " + selectedVehicleType.toUpperCase());
        titleLabel.setBounds(10, 10, 700, 40);
        contentPanel.add(titleLabel);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
    }

    private JPanel createVehiclePanel(int index, String imageUrl, String vehicleName, 
                                    double price, String description) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 0));
        panel.setPreferredSize(new Dimension(600, 120));
        panel.setBackground(new Color(255, 255, 255, 200));
        panel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 1));

        try {
            JPanel leftPanel = new JPanel(new BorderLayout(10, 0));
            leftPanel.setOpaque(false);

            ImageIcon imageIcon = new ImageIcon(new URL(imageUrl));
            Image image = imageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            JPanel infoPanel = new JPanel();
            infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
            infoPanel.setOpaque(false);

            JLabel nameLabel = new JLabel(vehicleName);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

            JLabel priceLabel = new JLabel(String.format("%.2f€/día", price));
            priceLabel.setFont(new Font("Arial", Font.BOLD, 12));
            
            JLabel descLabel = new JLabel("<html>" + description + "</html>");
            descLabel.setFont(new Font("Arial", Font.PLAIN, 11));

            infoPanel.add(nameLabel);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            infoPanel.add(priceLabel);
            infoPanel.add(Box.createRigidArea(new Dimension(0, 5)));
            infoPanel.add(descLabel);

            leftPanel.add(imageLabel, BorderLayout.WEST);
            leftPanel.add(infoPanel, BorderLayout.CENTER);
            panel.add(leftPanel, BorderLayout.CENTER);

            JButton reserveButton = new JButton("RESERVAR");
            reserveButton.setPreferredSize(new Dimension(120, 40));
            reserveButton.setBackground(new Color(0, 128, 255));
            reserveButton.setForeground(Color.WHITE);
            reserveButton.setFont(new Font("Arial", Font.BOLD, 14));
            reserveButton.setFocusPainted(false);

            reserveButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    reserveButton.setBackground(new Color(30, 144, 255));
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    reserveButton.setBackground(new Color(0, 128, 255));
                }
            });

            reserveButton.addActionListener(e -> {
                frame.dispose();
                Payment payment = new Payment(vehicleName, imageUrl, price, description);
                payment.getFrame().setVisible(true);
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setOpaque(false);
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
            buttonPanel.add(reserveButton);

            panel.add(buttonPanel, BorderLayout.EAST);

        } catch (Exception e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Error al cargar la imagen");
            errorLabel.setForeground(Color.RED);
            panel.add(errorLabel, BorderLayout.CENTER);
        }

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
