package SistemaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaInicio {

    Login lg = new Login();
    LoginDAO login = new LoginDAO();

    //-------------------------------

    private JPanel mainPanel;
    private JLabel imagenFondo;
    private JFrame ventana;
    private JButton inicioS;
    private JButton crear;
    private JFrame ventanaCuenta;
    private JTextField usuario;
    private JTextField password;

    public TiendaInicio(){
        //InitComponents();//funcion que invoca la primera ventana junto con todos sus componentes(botones, cajas de texto, imagenes...)
    }

    public void InitComponents(){
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

    public void validar() {

        String nombreUsuario = usuario.getText();
        String passUsuario = password.getText();

        if (usuario.getText().isEmpty() || password.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Introduzca su usuario y contraseña");
            usuario.requestFocus();

        } else {

            lg = login.log(nombreUsuario, passUsuario);

            if (lg.getNombre() != null && lg.getPass() != null) {

                ventana.dispose();
                TiendaMain x = new TiendaMain(); //funcion que lleva a la pagina "main" con todos los productos
                x.tienda();

            } else {

                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                usuario.requestFocus();
            }
        }
    }

    public void crearcuenta() {

        ventana.dispose();
        CreacionCuenta x = new CreacionCuenta();

    }

}
