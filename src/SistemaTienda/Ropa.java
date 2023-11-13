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

    public String[][] infoImagenes(){
        LeerEscribirBD x = new LeerEscribirBD();

        return(x.leerImagen());

        //comprobar que el array funciona correctamente
        /*String[][] aux = x.leerImagen();

        for(int i=0;i<2;i++){
            for(int j=0;j<6;j++){
                System.out.print(aux[i][j] + " |");
            }
            System.out.println();
        }*/
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
