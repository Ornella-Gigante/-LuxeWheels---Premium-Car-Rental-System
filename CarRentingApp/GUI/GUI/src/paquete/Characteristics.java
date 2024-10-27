package paquete;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerDateModel;

public class Characteristics {
    private JFrame frame;
    private JComboBox<String> vehicleTypeCombo;
    private JComboBox<String> officeCombo;
    private JSpinner pickupDateSpinner;
    private JSpinner returnDateSpinner;

    public Characteristics() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Características - Alquiler de Coches");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        
        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(143, 10, 300, 360);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);
        
        JLabel lblAdventure = new JLabel("¡ELIGE TU NUEVA AVENTURA!");
        lblAdventure.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdventure.setFont(new Font("Arial", Font.BOLD, 20));
        lblAdventure.setBounds(0, 20, 300, 30);
        contentPanel.add(lblAdventure);
        
        JLabel lblVehicleType = new JLabel("TIPO DE VEHÍCULO:");
        lblVehicleType.setFont(new Font("Arial", Font.BOLD, 14));
        lblVehicleType.setBounds(30, 60, 240, 25);
        contentPanel.add(lblVehicleType);
        
        String[] vehicleTypes = {
            "SUV - Todo Terreno",
            "Sedán - Familiar",
            "Deportivo",
            "Furgoneta",
            "Compacto",
            "Eléctrico"
        };
        vehicleTypeCombo = new JComboBox<>(vehicleTypes);
        vehicleTypeCombo.setBounds(30, 85, 240, 30);
        vehicleTypeCombo.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(vehicleTypeCombo);
        
        JLabel lblOffice = new JLabel("OFICINA DE RECOGIDA Y DEVOLUCIÓN:");
        lblOffice.setFont(new Font("Arial", Font.BOLD, 14));
        lblOffice.setBounds(30, 120, 240, 25);
        contentPanel.add(lblOffice);
        
        String[] offices = {
            "Av. Diagonal 523, Barcelona",
            "Passeig de Gràcia 78, Barcelona",
            "Rambla de Catalunya 45, Barcelona"
        };
        officeCombo = new JComboBox<>(offices);
        officeCombo.setBounds(30, 145, 240, 30);
        officeCombo.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(officeCombo);
        
        JLabel lblPickupDate = new JLabel("FECHA DE RECOGIDA:");
        lblPickupDate.setFont(new Font("Arial", Font.BOLD, 14));
        lblPickupDate.setBounds(30, 180, 240, 25);
        contentPanel.add(lblPickupDate);
        
        SpinnerDateModel modelPickup = new SpinnerDateModel();
        pickupDateSpinner = new JSpinner(modelPickup);
        JSpinner.DateEditor editorPickup = new JSpinner.DateEditor(pickupDateSpinner, "dd/MM/yyyy");
        pickupDateSpinner.setEditor(editorPickup);
        pickupDateSpinner.setBounds(30, 205, 240, 30);
        contentPanel.add(pickupDateSpinner);
        
        JLabel lblReturnDate = new JLabel("FECHA DE DEVOLUCIÓN:");
        lblReturnDate.setFont(new Font("Arial", Font.BOLD, 14));
        lblReturnDate.setBounds(30, 240, 240, 25);
        contentPanel.add(lblReturnDate);
        
        SpinnerDateModel modelReturn = new SpinnerDateModel();
        returnDateSpinner = new JSpinner(modelReturn);
        JSpinner.DateEditor editorReturn = new JSpinner.DateEditor(returnDateSpinner, "dd/MM/yyyy");
        returnDateSpinner.setEditor(editorReturn);
        returnDateSpinner.setBounds(30, 265, 240, 30);
        contentPanel.add(returnDateSpinner);
        
        JButton btnContinue = new JButton("CONTINUAR");
        btnContinue.setBackground(new Color(0, 128, 255));
        btnContinue.setForeground(Color.WHITE);
        btnContinue.setFont(new Font("Arial", Font.BOLD, 14));
        btnContinue.setBounds(170, 310, 120, 35);
        btnContinue.setFocusPainted(false);
        
        btnContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContinue.setBackground(new Color(30, 144, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContinue.setBackground(new Color(0, 128, 255));
            }
        });
        
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validateFields()) {
                    saveSelections();
                    frame.dispose();
                    ChooseVehicle chooseVehicle = new ChooseVehicle(getSelectedVehicleType());
                    chooseVehicle.getFrame().setVisible(true);
                }
            }
        });
        contentPanel.add(btnContinue);
    }
    
    private void saveSelections() {
        String selectedVehicleType = (String) vehicleTypeCombo.getSelectedItem();
        String selectedOffice = (String) officeCombo.getSelectedItem();
        Date pickupDate = (Date) pickupDateSpinner.getValue();
        Date returnDate = (Date) returnDateSpinner.getValue();
    }
    
    private boolean validateFields() {
        Date pickupDate = (Date) pickupDateSpinner.getValue();
        Date returnDate = (Date) returnDateSpinner.getValue();
        
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        
        if(pickupDate.before(today.getTime())) {
            JOptionPane.showMessageDialog(frame,
                "La fecha de recogida no puede ser anterior a hoy",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(pickupDate.after(returnDate)) {
            JOptionPane.showMessageDialog(frame,
                "La fecha de devolución debe ser posterior a la fecha de recogida",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    public String getSelectedVehicleType() {
        return (String) vehicleTypeCombo.getSelectedItem();
    }
    
    public String getSelectedOffice() {
        return (String) officeCombo.getSelectedItem();
    }
    
    public Date getPickupDate() {
        return (Date) pickupDateSpinner.getValue();
    }
    
    public Date getReturnDate() {
        return (Date) returnDateSpinner.getValue();
    }
    
    public JFrame getFrame() {
        return frame;
    }
}