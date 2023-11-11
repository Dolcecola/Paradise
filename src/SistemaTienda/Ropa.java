package SistemaTienda;

import javax.swing.*;

public class Ropa{

    String nombreImagen;

    Ropa(){}

    public void setNombreImagen(String n){
        nombreImagen = n;
    }

    public String getNombreImagen(){
        return nombreImagen;
    }

    public String[] mostrar(){
        LeerEscribirBD x = new LeerEscribirBD();
        //si falla el mostrar cambiar la linea de abajo
        return(x.leerImagen());
    }

    public boolean guardarImagen(JTextField imagen) {

        Ropa r = new Ropa();
        LeerEscribirBD le = new LeerEscribirBD();

        if (imagen.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Campos vacios");
            return false;

        } else {

            r.setNombreImagen(imagen.getText());

            le.escribirImagen(r);
            JOptionPane.showMessageDialog(null, "Imagen añadida");
            return true;
        }
    }
}
