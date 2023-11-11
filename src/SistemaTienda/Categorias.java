package SistemaTienda;

import javax.swing.*;

public class Categorias {
    JButton hombre = new JButton("Hombre");
    JButton mujer = new JButton("Mujer");
    JButton niños = new JButton("Niños");

    public Categorias(JPanel panel, JFrame ventana){

        panel.setLayout(null);

        int coordY = 255;
        hombre.setBounds(0,coordY+30,310,30);
        mujer.setBounds(0,coordY+60,310,30);
        niños.setBounds(0,coordY+90,310,30);

        panel.add(hombre);
        panel.add(mujer);
        panel.add(niños);

        ventana.add(panel);
    }
}
