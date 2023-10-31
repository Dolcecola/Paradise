package SistemaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionCuenta{

    Login l2 = new Login();
    CrearCuenta c = new CrearCuenta();

    //--------------------------------

    private JFrame ventanaCuenta;
    private JButton guardar;
    private JPanel panelSesion;
    private JLabel usuario;
    private JLabel password;
    private JLabel nombre;
    private JLabel apellidos;
    private JLabel email_usuario;
    private JLabel telefono_usuario;
    private JTextField nombreUsuarioCrear;
    private JTextField password2;
    private JTextField nombrePersona;
    private JTextField apellidosUsuario;
    private JTextField email;
    private JTextField telefono;
    private JLabel fondoCuenta;

    public CreacionCuenta(){
        VentanaCreacionCuenta();
    }

    public void VentanaCreacionCuenta(){

        ventanaCuenta = new JFrame();
        panelSesion = new JPanel();
        nombreUsuarioCrear = new JTextField();
        apellidosUsuario = new JTextField();
        email = new JTextField();
        telefono = new JTextField();
        nombrePersona = new JTextField();
        password2 = new JTextField();
        fondoCuenta = new JLabel();

        guardar = new JButton();

        panelSesion.setBackground(Color.WHITE);
        panelSesion.setLayout(null);

        nombreUsuarioCrear.setBounds(250, 50, 200, 28);
        password2.setBounds(250, 100, 200, 28);
        nombrePersona.setBounds(250, 150, 200, 28);
        apellidosUsuario.setBounds(250, 200, 200, 28);
        email.setBounds(250, 250, 200, 28);
        telefono.setBounds(250, 300, 200, 28);

        guardar.setText("Guardar");
        guardar.setBounds(310, 370, 90, 30);

        usuario = new JLabel();
        usuario.setText("Usuario");
        usuario.setBounds(114, 50, 150, 30);
        usuario.setHorizontalAlignment(SwingConstants.CENTER);
        usuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        password = new JLabel();
        password.setText("Contraseña");
        password.setBounds(100, 100, 150, 30);
        password.setHorizontalAlignment(SwingConstants.CENTER);
        password.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        nombre = new JLabel();
        nombre.setText("Nombre");
        nombre.setBounds(114, 150, 150, 30);
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        apellidos = new JLabel();
        apellidos.setText("Apellidos");
        apellidos.setBounds(110, 200, 150, 30);
        apellidos.setHorizontalAlignment(SwingConstants.CENTER);
        apellidos.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        email_usuario = new JLabel();
        email_usuario.setText("Email");
        email_usuario.setBounds(125, 250, 150, 30);
        email_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        email_usuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        telefono_usuario = new JLabel();
        telefono_usuario.setText("Telefono");
        telefono_usuario.setBounds(115, 300, 150, 30);
        telefono_usuario.setHorizontalAlignment(SwingConstants.CENTER);
        telefono_usuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        ImageIcon logo = new ImageIcon("fondo1.jpg");
        fondoCuenta.setBounds(0, 0, 500, 500);
        fondoCuenta.setIcon(new ImageIcon(logo.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH)));

        panelSesion.add(nombreUsuarioCrear);
        panelSesion.add(apellidosUsuario);
        panelSesion.add(email);
        panelSesion.add(telefono);
        panelSesion.add(nombrePersona);
        panelSesion.add(password2);
        panelSesion.add(guardar);
        panelSesion.add(usuario);
        panelSesion.add(password);
        panelSesion.add(nombre);
        panelSesion.add(apellidos);
        panelSesion.add(email_usuario);
        panelSesion.add(telefono_usuario);
        panelSesion.add(fondoCuenta);

        ventanaCuenta.setSize(500, 500);
        ventanaCuenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaCuenta.setLocationRelativeTo(null);
        ventanaCuenta.setResizable(false);
        ventanaCuenta.setVisible(true);
        ventanaCuenta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guardar.addActionListener(guardarCuenta);

        ventanaCuenta.add(panelSesion);
    }

    ActionListener guardarCuenta = new ActionListener() {//evento para guardar usuario en BD
        public void actionPerformed(ActionEvent g) {
            try {
                crearUsuario();
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Debe introducir datos válidos");
            }
        }
    };

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
            ventanaCuenta.dispose();
            TiendaInicio x = new TiendaInicio();
        }
    }
}
