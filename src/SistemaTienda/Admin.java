package SistemaTienda;

import javax.swing.*;
import java.security.PublicKey;

public class Admin extends Usuario{
    String nombre;
    String pass;

    public Admin(){}

    public Admin(String n, String p){
        this.nombre=n;
        this.pass=p;
    }

    public void setNombre(String n){
        nombre=n;
    }

    public void setPass(String p){
        pass=p;
    }

    String getNombre(){
        return nombre;
    }

    String getPass(){
        return pass;
    }
    @Override
    public boolean validar(JTextField nU, JTextField pU) {
        String nombreUsuario = nU.getText();
        String passUsuario = pU.getText();

        if (nU.getText().isEmpty() || pU.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Introduzca su usuario de administrador y contraseña");
            nU.requestFocus();
            return false;

        } else {

            Admin ad = new Admin();
            LeerEscribirBD le = new LeerEscribirBD();

            ad = le.leerAdmin(nombreUsuario, passUsuario);

            if (ad.getNombre() != null && ad.getPass() != null) {

                return true;

            } else {

                JOptionPane.showMessageDialog(null, "Administrador no encontrado");
                nU.requestFocus();
                return false;
            }
        }
    }
}
