package SistemaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaMain{

    private JFrame ventanaTienda;

    private JPanel mainTienda;

    private JLabel imagenC1;

    public TiendaMain(){}

        public void tienda(){


            ventanaTienda = new JFrame();
            mainTienda = new JPanel();
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
            ventanaTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ventanaTienda.add(mainTienda);
        }


}
