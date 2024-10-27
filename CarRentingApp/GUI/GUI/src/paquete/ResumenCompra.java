package paquete;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ResumenCompra {
    private JFrame frame;
    private String vehicleName;
    private String imageUrl;
    private double price;
    private String description;
    private boolean hasDiscount;
    private String paymentMethod;
    private String insuranceType;
    private static final double PREMIUM_INSURANCE_COST = 35.0;

    public ResumenCompra(String vehicleName, String imageUrl, double price, String description,
                        boolean hasDiscount, String paymentMethod, String insuranceType) {
        this.vehicleName = vehicleName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.hasDiscount = hasDiscount;
        this.paymentMethod = paymentMethod;
        this.insuranceType = insuranceType;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Resumen de Compra - Alquiler de Coches");
        frame.setBounds(100, 100, 800, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(104, 10, 600, 743);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);

        // Título
        JLabel titleLabel = new JLabel("RESUMEN DE SU RESERVA");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(0, 20, 600, 40);
        contentPanel.add(titleLabel);

        try {
            // Imagen del vehículo
            ImageIcon imageIcon = new ImageIcon(new URL(imageUrl));
            Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setBounds(150, 80, 300, 200);
            contentPanel.add(imageLabel);

            // Panel de detalles con borde y fondo semitransparente
            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(null);
            detailsPanel.setBounds(50, 300, 500, 160);
            detailsPanel.setBackground(new Color(255, 255, 255, 200));
            detailsPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 1));
            
            int y = 10;
            
            // Detalles del vehículo
            JLabel nameLabel = new JLabel("Vehículo: " + vehicleName);
            nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
            nameLabel.setBounds(20, y, 460, 20);
            detailsPanel.add(nameLabel);
            
            y += 25;
            
            JLabel descLabel = new JLabel("<html>Características: " + description + "</html>");
            descLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            descLabel.setBounds(20, y, 460, 40);
            detailsPanel.add(descLabel);
            
            y += 45;

            // Método de pago
            JLabel paymentLabel = new JLabel("Método de pago: " + paymentMethod);
            paymentLabel.setFont(new Font("Arial", Font.PLAIN, 12));
            paymentLabel.setBounds(20, y, 460, 20);
            detailsPanel.add(paymentLabel);

            contentPanel.add(detailsPanel);

            // Panel de precios
            JPanel pricesPanel = new JPanel();
            pricesPanel.setLayout(null);
            pricesPanel.setBounds(50, 480, 500, 120);
            pricesPanel.setBackground(new Color(255, 255, 255, 200));
            pricesPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 255), 1));

            // Cálculo de precios
            double basePrice = price;
            double discountAmount = 0;
            double insuranceCost = 0;
            double finalPrice = basePrice;

            int priceY = 10;

            // 1. Mostrar precio base
            JLabel baseLabel = new JLabel(String.format("Precio base por día: %.2f€", basePrice));
            baseLabel.setFont(new Font("Arial", Font.BOLD, 12));
            baseLabel.setBounds(20, priceY, 460, 20);
            pricesPanel.add(baseLabel);
            priceY += 20;

            // 2. Aplicar y mostrar descuento si corresponde
            if (hasDiscount) {
                discountAmount = basePrice * 0.20; // 20% de descuento
                finalPrice -= discountAmount;
                JLabel discountLabel = new JLabel(String.format("Descuento por alquiler prolongado: -%.2f€ (-20%%)", 
                    discountAmount));
                discountLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                discountLabel.setForeground(new Color(0, 128, 0));
                discountLabel.setBounds(20, priceY, 460, 20);
                pricesPanel.add(discountLabel);
                priceY += 20;
            }

            // 3. Aplicar y mostrar seguro
            if (insuranceType.equals("Premium")) {
                insuranceCost = PREMIUM_INSURANCE_COST;
                finalPrice += insuranceCost;
                JLabel insuranceLabel = new JLabel(String.format("Seguro Premium: +%.2f€", insuranceCost));
                insuranceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                insuranceLabel.setBounds(20, priceY, 460, 20);
                pricesPanel.add(insuranceLabel);
            } else {
                JLabel insuranceLabel = new JLabel("Seguro Básico: Incluido en precio base");
                insuranceLabel.setFont(new Font("Arial", Font.PLAIN, 12));
                insuranceLabel.setBounds(20, priceY, 460, 20);
                pricesPanel.add(insuranceLabel);
            }

            contentPanel.add(pricesPanel);

            // Subtotal
            JLabel subtotalLabel = new JLabel(String.format("Subtotal: %.2f€", finalPrice));
            subtotalLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            subtotalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            subtotalLabel.setBounds(50, 620, 500, 20);
            contentPanel.add(subtotalLabel);

            // Precio final destacado
            JLabel finalPriceLabel = new JLabel(String.format("PRECIO FINAL POR DÍA: %.2f€", finalPrice));
            finalPriceLabel.setFont(new Font("Arial", Font.BOLD, 20));
            finalPriceLabel.setForeground(new Color(0, 100, 0));
            finalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            finalPriceLabel.setBounds(0, 650, 600, 30);
            contentPanel.add(finalPriceLabel);

            // Botón Finalizar
            JButton finishButton = new JButton("FINALIZAR");
            finishButton.setBackground(new Color(0, 128, 255));
            finishButton.setForeground(Color.WHITE);
            finishButton.setFont(new Font("Arial", Font.BOLD, 14));
            finishButton.setBounds(240, 690, 120, 40);
            finishButton.setFocusPainted(false);

            finishButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    finishButton.setBackground(new Color(30, 144, 255));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    finishButton.setBackground(new Color(0, 128, 255));
                }
            });

            finishButton.addActionListener(e -> {
                frame.dispose();
                Goodbye goodbye = new Goodbye();
                goodbye.getFrame().setVisible(true);
            });
            
            contentPanel.add(finishButton);

        } catch (Exception e) {
            e.printStackTrace();
            JLabel errorLabel = new JLabel("Error al cargar la imagen");
            errorLabel.setForeground(Color.RED);
            contentPanel.add(errorLabel);
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
