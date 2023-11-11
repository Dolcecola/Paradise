package SistemaTienda;

import javax.swing.*;

public class Cliente extends Usuario{
    String nombre;
    String pass;
    String usuario;
    String apellidos;
    String email;
    int telefono = 0;

    public Cliente() {
    }

    public Cliente(String n, String p, String u, String a, String e, int t) {
        this.nombre = n;
        this.pass = p;
        this.usuario = u;
        this.apellidos = a;
        this.email = e;
        this.telefono = t;
    }

    public void setUsuario(String u) {
        usuario = u;
    }

    public void setApellidos(String a) {
        apellidos = a;
    }

    public void setEmail(String e) {
        email = e;
    }

    public void setTelefono(int t) {
        telefono = t;
    }

    String getUsuario() {
        return usuario;
    }

    String getApellidos() {
        return apellidos;
    }

    String getEmail() {
        return email;
    }

    int getTelefono() {
        return telefono;
    }

    public void setNombre(String n) {
        nombre = n;
    }

    public void setPass(String p) {
        pass = p;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPass() {
        return pass;
    }


    @Override
    public boolean validar(JTextField nU, JTextField pU) {

        String nombreUsuario = nU.getText();
        String passUsuario = pU.getText();

        if (nU.getText().isEmpty() || pU.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Introduzca su usuario y contraseña");
            nU.requestFocus();
            return false;

        } else {

            Cliente lg = new Cliente();
            LeerEscribirBD le = new LeerEscribirBD();

            lg = le.log(nombreUsuario, passUsuario);

            if (lg.getNombre() != null && lg.getPass() != null) {

                return true;

            } else {

                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                nU.requestFocus();
                return false;
            }
        }
    }

    public boolean crearUsuario(JTextField usuario, JTextField password, JTextField nombre, JTextField apellidos, JTextField email, JTextField telefono) {

        Cliente lg = new Cliente();
        LeerEscribirBD le = new LeerEscribirBD();

        if (usuario.getText().isEmpty() || password.getText().isEmpty() || nombre.getText().isEmpty() || apellidos.getText().isEmpty() || email.getText().isEmpty() || telefono.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Campos vacios");
            return false;

        } else {

            lg.setUsuario(usuario.getText());
            lg.setPass(password.getText());
            lg.setNombre(nombre.getText());
            lg.setApellidos(apellidos.getText());
            lg.setEmail(email.getText());
            lg.setTelefono(Integer.parseInt(telefono.getText()));

            le.RegistrarUsuario(lg);
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
            return true;
        }
    }
}
