package SistemaTienda;

import com.mysql.cj.log.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends JFrame {
    Login lg = new Login();
    LoginDAO login = new LoginDAO();

    private JPanel mainPanel;
    private JLabel imagenFondo;
    private JFrame ventana;
    private JButton inicioS;
    private JButton crear;
    private JFrame ventanaCuenta;
    JTextField usuario;
    JTextField password;

    //------------------

    private JButton guardar;
    private JPanel panelSesion;
    private JTextField nombreUsuarioCrear;
    private JTextField password2;
    private JTextField nombrePersona;
    private JTextField apellidosUsuario;
    private JTextField email;
    private JTextField telefono;
    Login l2 = new Login();
    CrearCuenta c = new CrearCuenta();
    //----------------

    JLabel imagenC1;

    public Main() {
        InitComponents();
    }

    public void InitComponents() {
        ventana = new JFrame("Paradise");
        mainPanel = new JPanel();
        imagenFondo = new JLabel();

        crear = new JButton();
        crear.setText("crear cuenta");
        crear.setBounds(600, 255, 120, 30);
        crear.setHorizontalAlignment(SwingConstants.CENTER);
        crear.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        inicioS = new JButton();
        inicioS.setText("acceder");
        inicioS.setBounds(460, 255, 90, 30);
        inicioS.setHorizontalAlignment(SwingConstants.CENTER);
        inicioS.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JLabel nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(310, 155, 150, 30);
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        password = new JTextField();
        password.setBounds(430, 215, 200, 30);

        JLabel cont = new JLabel();
        cont.setText("Contraseña");
        cont.setBounds(300, 215, 150, 30);
        cont.setHorizontalAlignment(SwingConstants.CENTER);
        cont.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        usuario = new JTextField();
        usuario.setBounds(430, 155, 200, 30);

        JLabel login = new JLabel();
        login.setText("Iniciar Sesión");
        login.setBounds(400, 10, 200, 200);
        login.setHorizontalAlignment(SwingConstants.CENTER);
        login.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        Color f = new Color(235, 236, 218);

        mainPanel.setLayout(null);
        mainPanel.setBackground(f);

        ImageIcon logo = new ImageIcon("logoTienda.jpg");
        imagenFondo.setBounds(0, 0, 300, 300);
        imagenFondo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

        mainPanel.add(crear);
        mainPanel.add(inicioS);
        mainPanel.add(password);
        mainPanel.add(cont);
        mainPanel.add(nombre);
        mainPanel.add(usuario);
        mainPanel.add(login);
        mainPanel.add(imagenFondo);

        ventana.setSize(800, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        //nombreUsuario = usuario.getText();
        //passUsuario = password.getText();

        crear.addActionListener(CrearCuenta);
        inicioS.addActionListener(acceder);

        ventana.add(mainPanel);
    }

    ActionListener acceder = new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            validar();
        }
    };

    ActionListener CrearCuenta = new ActionListener() {
        public void actionPerformed(ActionEvent f) {
            crearcuenta();
        }
    };

    ActionListener guardarCuenta = new ActionListener() {//evento para guardar usuario en BD
        public void actionPerformed(ActionEvent g) {
            try {
                crearUsuario();
            }
            catch (NumberFormatException e) {

            }
        }
    };


    public void tienda() {

        ventana.dispose();
        JFrame ventanaTienda = new JFrame();
        JPanel mainTienda = new JPanel();
        imagenC1 = new JLabel();

        mainTienda.setBackground(Color.WHITE);
        mainTienda.setLayout(null);

        ImageIcon camiseta1 = new ImageIcon("CamisetaHombre1.png");
        imagenC1.setBounds(50, 150, 200, 200);
        imagenC1.setIcon(new ImageIcon(camiseta1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));

        mainTienda.add(imagenC1);

        ventanaTienda.setVisible(true);
        ventanaTienda.setSize(1300, 1000);
        ventanaTienda.setLocationRelativeTo(null);

        ventanaTienda.add(mainTienda);

    }

    public void crearcuenta() {
        ventanaCuenta = new JFrame();
        panelSesion = new JPanel();
        nombreUsuarioCrear = new JTextField();
        apellidosUsuario = new JTextField();
        email = new JTextField();
        telefono = new JTextField();
        nombrePersona = new JTextField();
        password2 = new JTextField();

        guardar = new JButton();
        ventana.dispose();

        panelSesion.setBackground(Color.BLACK);
        panelSesion.setLayout(null);

        nombreUsuarioCrear.setBounds(250, 50, 150, 30);
        password2.setBounds(250, 100, 150, 30);
        nombrePersona.setBounds(250, 150, 150, 30);
        apellidosUsuario.setBounds(250, 200, 150, 30);
        email.setBounds(250, 250, 150, 30);
        telefono.setBounds(250, 300, 150, 30);

        guardar.setText("Guardar");
        guardar.setBounds(300, 350, 90, 30);

        panelSesion.add(nombreUsuarioCrear);
        panelSesion.add(apellidosUsuario);
        panelSesion.add(email);
        panelSesion.add(telefono);
        panelSesion.add(nombrePersona);
        panelSesion.add(password2);
        panelSesion.add(guardar);

        ventanaCuenta.setSize(600, 900);
        ventanaCuenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaCuenta.setLocationRelativeTo(null);
        ventanaCuenta.setResizable(false);
        ventanaCuenta.setVisible(true);

        guardar.addActionListener(guardarCuenta);

        ventanaCuenta.add(panelSesion);
    }

    public void crearUsuario() {
        if (nombreUsuarioCrear.getText().isEmpty() || password2.getText().isEmpty() || nombrePersona.getText().isEmpty() || apellidosUsuario.getText().isEmpty() || email.getText().isEmpty() || telefono.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Campos vacios");

        } else {

            l2.setUsuario(nombreUsuarioCrear.getText());
            l2.setPass(password2.getText());
            l2.setNombre(nombrePersona.getText());
            l2.setApellidos(apellidosUsuario.getText());
            l2.setEmail(email.getText());
            l2.setTelefono(Integer.parseInt(telefono.getText()));

            c.RegistrarUsuario(l2);
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
        }
    }

    public void validar() {
        String nombreUsuario = usuario.getText();
        String passUsuario = password.getText();

        if (usuario.getText().isEmpty() || password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduzca su usuario y contraseña");
            usuario.requestFocus();
        } else {
            lg = login.log(nombreUsuario, passUsuario);
            if (lg.getNombre() != null && lg.getPass() != null) {
                tienda();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no encontrado");
                usuario.requestFocus();
            }
        }
    }

    public static void main(String[] args) {
        Main ventana = new Main();

        //Connection bd = ConectarBD(); comprobar conexoin con base de datos
    }

}