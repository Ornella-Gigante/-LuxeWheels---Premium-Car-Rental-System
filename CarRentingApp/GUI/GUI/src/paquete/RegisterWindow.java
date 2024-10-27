package paquete;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RegisterWindow {
    private JFrame frame;
    private JTextField userField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private WelcomeWindow welcomeWindow;

    public RegisterWindow(WelcomeWindow welcomeWindow) {
        this.welcomeWindow = welcomeWindow;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Registro - Alquiler de Coches");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                welcomeWindow.getFrame().setVisible(true);
            }
        });
        
        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(150, 50, 300, 300);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);
        
        JLabel lblRegister = new JLabel("¡¡¡REGÍSTRATE!!!");
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setFont(new Font("Arial", Font.BOLD, 28));
        lblRegister.setBounds(0, 20, 300, 40);
        contentPanel.add(lblRegister);
        
        JLabel lblUser = new JLabel("USUARIO:");
        lblUser.setFont(new Font("Arial", Font.BOLD, 14));
        lblUser.setBounds(40, 70, 220, 25);
        contentPanel.add(lblUser);
        
        userField = new JTextField();
        userField.setBounds(40, 95, 220, 30);
        userField.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(userField);
        
        JLabel lblEmail = new JLabel("E-MAIL:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
        lblEmail.setBounds(40, 130, 220, 25);
        contentPanel.add(lblEmail);
        
        emailField = new JTextField();
        emailField.setBounds(40, 155, 220, 30);
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(emailField);
        
        JLabel lblPassword = new JLabel("CONTRASEÑA:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        lblPassword.setBounds(40, 190, 220, 25);
        contentPanel.add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(40, 215, 220, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(passwordField);
        
        JButton btnContinue = new JButton("CONTINUAR");
        btnContinue.setBackground(new Color(0, 128, 0));
        btnContinue.setForeground(Color.WHITE);
        btnContinue.setFont(new Font("Arial", Font.BOLD, 14));
        btnContinue.setBounds(75, 260, 150, 35);
        btnContinue.setFocusPainted(false);
        
        btnContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnContinue.setBackground(new Color(0, 150, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnContinue.setBackground(new Color(0, 128, 0));
            }
        });
        
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(validateFields()) {
                    frame.dispose();
                    RegisterContinue registerContinue = new RegisterContinue();
                    registerContinue.getFrame().setVisible(true);
                }
            }
        });
        contentPanel.add(btnContinue);
    }
    
    private boolean validateFields() {
        if(userField.getText().isEmpty() || 
           emailField.getText().isEmpty() || 
           passwordField.getPassword().length == 0) {
            
            JOptionPane.showMessageDialog(frame,
                "Por favor, complete todos los campos",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!emailField.getText().contains("@") || !emailField.getText().contains(".")) {
            JOptionPane.showMessageDialog(frame,
                "Por favor, ingrese un email válido",
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
