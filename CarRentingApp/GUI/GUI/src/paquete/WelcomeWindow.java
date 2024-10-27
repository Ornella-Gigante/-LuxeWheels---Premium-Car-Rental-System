package paquete;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeWindow {
    private JFrame frame;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WelcomeWindow window = new WelcomeWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public WelcomeWindow() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Bienvenido - Alquiler de Coches");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        JPanel mainPanel = new BackgroundPanel();
        mainPanel.setLayout(null);
        frame.setContentPane(mainPanel);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setBounds(150, 50, 300, 300);
        contentPanel.setBackground(new Color(255, 255, 255, 180));
        mainPanel.add(contentPanel);
        
        JLabel lblWelcome = new JLabel("¡Bienvenido!");
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 28));
        lblWelcome.setBounds(0, 30, 300, 40);
        contentPanel.add(lblWelcome);
        
        JLabel lblMessage = new JLabel("<html><center>Sistema de Alquiler de Coches<br>Tu mejor opción para viajar</center></html>");
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        lblMessage.setFont(new Font("Arial", Font.PLAIN, 16));
        lblMessage.setBounds(20, 80, 260, 60);
        contentPanel.add(lblMessage);
        
        JButton btnSignUp = new JButton("SIGN UP");
        btnSignUp.setBackground(new Color(0, 128, 0));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 14));
        btnSignUp.setBounds(50, 160, 200, 40);
        btnSignUp.setFocusPainted(false);
        
        btnSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSignUp.setBackground(new Color(0, 150, 0));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSignUp.setBackground(new Color(0, 128, 0));
            }
        });
        
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                RegisterWindow registerWindow = new RegisterWindow(WelcomeWindow.this);
                registerWindow.getFrame().setVisible(true);
            }
        });
        contentPanel.add(btnSignUp);
        
        JButton btnLogin = new JButton("LOG IN");
        btnLogin.setBackground(new Color(0, 128, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setBounds(50, 220, 200, 40);
        btnLogin.setFocusPainted(false);
        
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(30, 144, 255));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogin.setBackground(new Color(0, 128, 255));
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                LoginWindow loginWindow = new LoginWindow(WelcomeWindow.this);
                loginWindow.getFrame().setVisible(true);
            }
        });
        contentPanel.add(btnLogin);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}
