# 🚗 LuxeWheels - Premium Car Rental System

<div align="center">

![LuxeWheels Banner](https://img.freepik.com/free-photo/luxury-car-parked-highway-with-modern-buildings-sunset_181624-60607.jpg)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=oracle&logoColor=white)](https://www.java.com/)
[![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![JDK](https://img.shields.io/badge/JDK-8+-green.svg?style=for-the-badge)](https://www.oracle.com/java/technologies/downloads/)
[![License](https://img.shields.io/badge/License-MIT-red.svg?style=for-the-badge)](LICENSE)

[Features](#features) · [Installation](#installation) · [Documentation](#documentation) · [Contributing](#contributing)

</div>

## 📋 About The Project

LuxeWheels is a sophisticated Java-based car rental management system designed to provide a premium booking experience. This desktop application streamlines the vehicle rental process with real-time pricing, insurance options, and automated discount calculations.

### 🌟 Key Highlights
- 💼 Professional-grade rental management solution
- 🎨 Modern and intuitive Swing GUI
- 🔄 Real-time pricing and availability
- 🛡️ Built-in insurance options
- 💰 Automatic discount system

## ⚙️ Built With

### Core Technologies
<table>
<tr>
    <td align="center" width="96">
        <img src="https://techstack-generator.vercel.app/java-icon.svg" alt="Java" width="48" height="48" />
        <br>Java SE 8+
    </td>
    <td align="center" width="96">
        <img src="https://skillicons.dev/icons?i=java" alt="Swing" width="48" height="48" />
        <br>Swing GUI
    </td>
    <td align="center" width="96">
        <img src="https://techstack-generator.vercel.app/github-icon.svg" alt="icon" width="48" height="48" />
        <br>Git
    </td>
</tr>
</table>

### Architecture & Patterns
```mermaid
graph LR
    A[MVC Architecture] --> B[Event-Driven]
    B --> C[OOP Principles]
    C --> D[Custom Components]
```

### Key Components
- **Java Development Kit (JDK) 8+**
  - Core programming language
  - Collections Framework
  - Stream API
  - Date/Time API

- **Swing Framework Components**
  - JFrame, JPanel
  - JButton, JLabel
  - JTextField, JPasswordField
  - JComboBox, JRadioButton
  - Custom BackgroundPanel

- **Additional Technologies**
  - Event Handling System
  - Image Processing
  - Layout Management
  - Form Validation

## 🚀 Getting Started

### Prerequisites
```markdown
- Java JDK 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans)
- Git
```

### Installation

1. Clone the repository
```bash
git clone https://github.com/yourusername/LuxeWheels.git
```

2. Navigate to project directory
```bash
cd LuxeWheels
```

3. Compile the project
```bash
javac paquete/*.java
```

4. Run the application
```bash
java paquete.WelcomeWindow
```

## 🎯 Features

### User Interface
- Responsive design
- Custom background panels
- Intuitive navigation
- Real-time feedback

### Vehicle Management
- Multiple categories
- Dynamic pricing
- Real-time availability
- Detailed specifications

### Booking System
- User authentication
- Date validation
- Location selection
- Payment processing
- Insurance options

## 📸 Screenshots

<div align="center">
<img src="https://github.com/Ornella-Gigante/LuxeWheels-Premium-Car-Rental-System/blob/main/WELCOME.png" alt="Welcome Screen" width="250"/>
<img src="https://github.com/Ornella-Gigante/LuxeWheels-Premium-Car-Rental-System/blob/main/selection.png" alt="Vehicle Selection" width="250"/>
<img src="https://github.com/Ornella-Gigante/LuxeWheels-Premium-Car-Rental-System/blob/main/payment.png" alt="Payment Process" width="250"/>
</div>


## 🤝 Contributing

We welcome contributions! Follow these steps:

1. Fork the project
2. Create your feature branch
```bash
git checkout -b feature/AmazingFeature
```
3. Commit your changes
```bash
git commit -m 'Add some AmazingFeature'
```
4. Push to the branch
```bash
git push origin feature/AmazingFeature
```
5. Open a Pull Request

## 📘 Documentation

For detailed documentation, please visit our [Wiki](link-to-wiki).

### Class Structure
```mermaid
classDiagram
    WelcomeWindow --|> RegisterWindow
    WelcomeWindow --|> LoginWindow
    RegisterWindow --|> Characteristics
    LoginWindow --|> Characteristics
    Characteristics --|> ChooseVehicle
    ChooseVehicle --|> Payment
    Payment --|> ResumenCompra
    ResumenCompra --|> Goodbye
```

## 📝 License

Distributed under the MIT License. See `LICENSE` file for more information.


---

<div align="center">
  
⭐️ If you find this project useful, please consider giving it a star!

[![GitHub stars](https://img.shields.io/github/stars/yourusername/LuxeWheels.svg?style=social&label=Star)](https://github.com/yourusername/LuxeWheels/stargazers/)

</div>
