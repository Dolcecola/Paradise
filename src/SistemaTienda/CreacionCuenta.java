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
    private JTextField nombreUsuarioCrear;
    private JTextField password2;
    private JTextField nombrePersona;
    private JTextField apellidosUsuario;
    private JTextField email;
    private JTextField telefono;

    public CreacionCuenta(){
        VentanaCreacionCuenta();
    }

    public void VentanaCreacionCuenta(){

        JFrame ventanaCuenta = new JFrame();
        panelSesion = new JPanel();
        nombreUsuarioCrear = new JTextField();
        apellidosUsuario = new JTextField();
        email = new JTextField();
        telefono = new JTextField();
        nombrePersona = new JTextField();
        password2 = new JTextField();

        guardar = new JButton();
        //ventana.dispose();

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

    ActionListener guardarCuenta = new ActionListener() {//evento para guardar usuario en BD
        public void actionPerformed(ActionEvent g) {
            try {
                crearUsuario();
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,"Debe introducir un texto");
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
        }
    }
}
