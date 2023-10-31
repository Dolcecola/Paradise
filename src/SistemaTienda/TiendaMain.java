package SistemaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaMain{

    private JFrame ventanaTienda;

    private JPanel mainTienda;

    private JLabel imagenC1;
    private JLabel fondoMain;
    private JLabel bannerMain;
    private JLabel imagenP2;
    private JLabel imagenP3;
    private JLabel bannerDown;

    public TiendaMain(){}

        public void tienda(){


            ventanaTienda = new JFrame();
            mainTienda = new JPanel();
            imagenC1 = new JLabel();
            fondoMain = new JLabel();
            bannerMain = new JLabel();
            imagenP2 = new JLabel();
            imagenP3 = new JLabel();
            bannerDown = new JLabel();

            mainTienda.setBackground(Color.WHITE);
            mainTienda.setLayout(null);

            ImageIcon camiseta1 = new ImageIcon("prenda1.jpg");
            imagenC1.setBounds(350, 350, 150, 150);
            imagenC1.setIcon(new ImageIcon(camiseta1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

            ImageIcon prenda2 = new ImageIcon("prenda2.jpg");
            imagenP2.setBounds(550, 350, 150, 150);
            imagenP2.setIcon(new ImageIcon(prenda2.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

            ImageIcon prenda3 = new ImageIcon("prenda3.jpg");
            imagenP3.setBounds(750, 350, 150, 150);
            imagenP3.setIcon(new ImageIcon(prenda3.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

            ImageIcon logo = new ImageIcon("fondoTienda.jpg");
            fondoMain.setBounds(0, 210, 1500, 1000);
            fondoMain.setIcon(new ImageIcon(logo.getImage().getScaledInstance(1500, 1000, Image.SCALE_SMOOTH)));

            ImageIcon banner = new ImageIcon("banner2.jpg");
            bannerMain.setBounds(0, 0, 1500, 200);
            bannerMain.setIcon(new ImageIcon(banner.getImage().getScaledInstance(1500, 200, Image.SCALE_SMOOTH)));

            ImageIcon bajoBanner = new ImageIcon("bajoBanner.jpg");
            bannerDown.setBounds(0, 200, 1500, 10);
            bannerDown.setIcon(new ImageIcon(bajoBanner.getImage().getScaledInstance(1500, 10, Image.SCALE_SMOOTH)));

            mainTienda.add(imagenC1);
            mainTienda.add(imagenP2);
            mainTienda.add(imagenP3);
            mainTienda.add(bannerDown);
            mainTienda.add(fondoMain);
            mainTienda.add(bannerMain);

            ventanaTienda.setVisible(true);
            ventanaTienda.setSize(1500, 1000);
            ventanaTienda.setLocationRelativeTo(null);
            ventanaTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ventanaTienda.add(mainTienda);
        }


}
