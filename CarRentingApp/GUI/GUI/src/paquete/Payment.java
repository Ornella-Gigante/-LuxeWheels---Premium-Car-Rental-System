package paquete;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payment {
    private JFrame frame;
    private JComboBox<String> paymentComboBox;
    private JRadioButton basicInsurance;
    private JRadioButton premiumInsurance;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private String vehicleName;
    private String imageUrl;
    private double price;
    private String description;

    public Payment(String vehicleName, String imageUrl, double price, String description) {
        this.vehicleName = vehicleName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        initialize(vehicleName);
    }

    private void initialize(String vehicleName) {
        frame = new JFrame();
        frame.setTitle("Resumen de Reserva - " + vehicleName);
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);

        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(51, 53, 696, 475);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);

        JLabel titleLabel = new JLabel("RESUMEN DE SU RESERVA");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(0, 20, 700, 40);
        contentPanel.add(titleLabel);

        JLabel paymentLabel = new JLabel("PAGO:");
        paymentLabel.setFont(new Font("Arial", Font.BOLD, 18));
        paymentLabel.setBounds(20, 126, 100, 30);
        contentPanel.add(paymentLabel);

        String[] paymentOptions = {"Tarjeta de Crédito", "Transferencia Bancaria", "PayPal"};
        paymentComboBox = new JComboBox<>(paymentOptions);
        paymentComboBox.setBounds(120, 128, 250, 30);
        contentPanel.add(paymentComboBox);

        JLabel insuranceLabel = new JLabel("SEGURO:");
        insuranceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        insuranceLabel.setBounds(20, 220, 100, 30);
        contentPanel.add(insuranceLabel);

        basicInsurance = new JRadioButton("Básico (añadido a las tarifas de alquiler)");
        premiumInsurance = new JRadioButton("Premium (35 euros)");
        ButtonGroup insuranceGroup = new ButtonGroup();
        insuranceGroup.add(basicInsurance);
        insuranceGroup.add(premiumInsurance);

        JPanel insurancePanel = new JPanel();
        insurancePanel.setLayout(new BoxLayout(insurancePanel, BoxLayout.Y_AXIS));
        insurancePanel.setBounds(120, 212, 400, 60);
        insurancePanel.add(basicInsurance);
        insurancePanel.add(premiumInsurance);
        contentPanel.add(insurancePanel);

        JLabel longRentalLabel = new JLabel("ALQUILER PROLONGADO (+1 SEMANA)");
        longRentalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        longRentalLabel.setFont(new Font("Arial", Font.BOLD, 18));
        longRentalLabel.setBounds(-74, 304, 700, 30);
        contentPanel.add(longRentalLabel);

        JLabel discountLabel = new JLabel("!!!-20% DESCUENTO!!!");
        discountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        discountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        discountLabel.setForeground(new Color(0, 128, 0));
        discountLabel.setBounds(-64, 344, 700, 30);
        contentPanel.add(discountLabel);

        yesRadioButton = new JRadioButton("Sí");
        noRadioButton = new JRadioButton("No");
        ButtonGroup rentalGroup = new ButtonGroup();
        rentalGroup.add(yesRadioButton);
        rentalGroup.add(noRadioButton);

        JPanel rentalPanel = new JPanel();
        rentalPanel.setBounds(185, 383, 200, 30);
        rentalPanel.add(yesRadioButton);
        rentalPanel.add(noRadioButton);
        contentPanel.add(rentalPanel);

        JButton confirmButton = new JButton("CONFIRMAR");
        confirmButton.setBackground(new Color(0, 128, 255));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(new Font("Arial", Font.BOLD, 14));
        confirmButton.setBounds(534, 413, 120, 40);
        confirmButton.setFocusPainted(false);

        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmButton.setBackground(new Color(30, 144, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmButton.setBackground(new Color(0, 128, 255));
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validatePaymentFields()) {
                    frame.dispose();
                    boolean hasDiscount = yesRadioButton.isSelected();
                    String insuranceType = basicInsurance.isSelected() ? "Básico" : "Premium";
                    String paymentMethod = (String) paymentComboBox.getSelectedItem();
                    
                    ResumenCompra resumen = new ResumenCompra(
                        vehicleName, 
                        imageUrl, 
                        price, 
                        description,
                        hasDiscount,
                        paymentMethod,
                        insuranceType
                    );
                    resumen.getFrame().setVisible(true);
                }
            }
        });

        contentPanel.add(confirmButton);
    }

    private boolean validatePaymentFields() {
        if (paymentComboBox.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(frame,
                "Por favor seleccione un método de pago",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!basicInsurance.isSelected() && !premiumInsurance.isSelected()) {
            JOptionPane.showMessageDialog(frame,
                "Por favor seleccione un tipo de seguro",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!yesRadioButton.isSelected() && !noRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(frame,
                "Por favor indique si desea alquiler prolongado",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }

    public JFrame getFrame() {
        return frame;
    }
}