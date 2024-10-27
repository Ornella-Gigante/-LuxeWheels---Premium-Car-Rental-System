package paquete;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginWindow {
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private WelcomeWindow welcomeWindow;

    public LoginWindow(WelcomeWindow welcomeWindow) {
        this.welcomeWindow = welcomeWindow;
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Login - Alquiler de Coches");
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
        contentPanel.setBackground(new Color(255, 255, 255, 200));
        mainPanel.add(contentPanel);
        
        JLabel lblWelcome = new JLabel("¡HOLA DE NUEVO!");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 28));
        lblWelcome.setBounds(0, 30, 300, 40);
        contentPanel.add(lblWelcome);
        
        JLabel lblEmail = new JLabel("E-MAIL:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 14));
        lblEmail.setBounds(40, 90, 220, 25);
        contentPanel.add(lblEmail);
        
        emailField = new JTextField();
        emailField.setBounds(40, 120, 220, 30);
        emailField.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(emailField);
        
        JLabel lblPassword = new JLabel("CONTRASEÑA:");
        lblPassword.setFont(new Font("Arial", Font.BOLD, 14));
        lblPassword.setBounds(40, 160, 220, 25);
        contentPanel.add(lblPassword);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(40, 190, 220, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 12));
        contentPanel.add(passwordField);
        
        JButton btnAccept = new JButton("ACEPTAR");
        btnAccept.setBackground(new Color(0, 128, 255));
        btnAccept.setForeground(Color.WHITE);
        btnAccept.setFont(new Font("Arial", Font.BOLD, 14));
        btnAccept.setBounds(75, 240, 150, 40);
        btnAccept.setFocusPainted(false);
        
        btnAccept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(emailField.getText().isEmpty() || passwordField.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(frame,
                        "Por favor, complete todos los campos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                } else {
                    frame.dispose();
                    Characteristics characteristicsWindow = new Characteristics();
                    characteristicsWindow.getFrame().setVisible(true);
                }
            }
        });
        contentPanel.add(btnAccept);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}