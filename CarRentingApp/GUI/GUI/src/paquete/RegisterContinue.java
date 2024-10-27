package paquete;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RegisterContinue {
    private JFrame frame;
    private JComboBox<String> genderCombo;
    private JSlider ageSlider;
    private JCheckBox termsCheckBox;
    private JCheckBox dataCheckBox;
    private JLabel ageValueLabel;
    
    public RegisterContinue() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Registro Continuación - Alquiler de Coches");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        
        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(150, 50, 300, 300);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);
        
        JLabel lblReady = new JLabel("¡¡YA CASI ESTÁS LISTO!!");
        lblReady.setHorizontalAlignment(SwingConstants.CENTER);
        lblReady.setFont(new Font("Arial", Font.BOLD, 24));
        lblReady.setBounds(0, 20, 300, 40);
        contentPanel.add(lblReady);
        
        JLabel lblGender = new JLabel("GÉNERO:");
        lblGender.setFont(new Font("Arial", Font.BOLD, 14));
        lblGender.setBounds(40, 70, 220, 25);
        contentPanel.add(lblGender);
        
        String[] genders = {"FEMENINO", "MASCULINO", "OTRO"};
        genderCombo = new JComboBox<>(genders);
        genderCombo.setBounds(40, 95, 220, 30);
        genderCombo.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(genderCombo);
        
        JLabel lblAge = new JLabel("EDAD:");
        lblAge.setFont(new Font("Arial", Font.BOLD, 14));
        lblAge.setBounds(40, 135, 160, 25);
        contentPanel.add(lblAge);
        
        ageValueLabel = new JLabel("18 años");
        ageValueLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ageValueLabel.setBounds(200, 135, 60, 25);
        contentPanel.add(ageValueLabel);
        
        ageSlider = new JSlider(JSlider.HORIZONTAL, 18, 99, 18);
        ageSlider.setBounds(40, 160, 220, 30);
        ageSlider.setOpaque(false);
        ageSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                ageValueLabel.setText(ageSlider.getValue() + " años");
            }
        });
        contentPanel.add(ageSlider);
        
        termsCheckBox = new JCheckBox("Acepto los Términos y Condiciones");
        termsCheckBox.setBounds(40, 200, 220, 25);
        termsCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
        termsCheckBox.setOpaque(false);
        contentPanel.add(termsCheckBox);
        
        dataCheckBox = new JCheckBox("Compartir Data");
        dataCheckBox.setBounds(40, 230, 220, 25);
        dataCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
        dataCheckBox.setOpaque(false);
        contentPanel.add(dataCheckBox);
        
        JButton btnContinue = new JButton("CONTINUAR");
        btnContinue.setBackground(new Color(0, 128, 255));
        btnContinue.setForeground(Color.WHITE);
        btnContinue.setFont(new Font("Arial", Font.BOLD, 14));
        btnContinue.setBounds(150, 260, 120, 35);
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
                    frame.dispose();
                    Characteristics characteristicsWindow = new Characteristics();
                    characteristicsWindow.getFrame().setVisible(true);
                }
            }
        });
        contentPanel.add(btnContinue);
    }
    
    private boolean validateFields() {
        if(!termsCheckBox.isSelected()) {
            JOptionPane.showMessageDialog(frame,
                "Debe aceptar los términos y condiciones para continuar",
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
