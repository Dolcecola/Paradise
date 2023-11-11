package SistemaTienda;

import javax.swing.*;
import javax.xml.catalog.Catalog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaMain{

    private JFrame ventanaTienda;
    private JPanel mainTienda;
    private JLabel fondoMain;
    private JTextField nombreImagen;

    public TiendaMain(boolean x){
        tienda(x);
    }

        public void tienda(boolean x){

            JLabel Logo = new JLabel();
            JButton Categoria = new JButton();

            ventanaTienda = new JFrame();
            mainTienda = new JPanel();
            fondoMain = new JLabel();

            mainTienda.setBackground(Color.WHITE);
            mainTienda.setLayout(null);

            Logo.setText("MSB");
            Logo.setBounds(700, 100, 150, 30);
            Logo.setHorizontalAlignment(SwingConstants.CENTER);
            Logo.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            Categoria.setText("Categorías");
            Categoria.setBounds(0, 255, 310, 30);
            Categoria.setHorizontalAlignment(SwingConstants.CENTER);
            Categoria.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            Categoria.setBackground(Color.gray);

            ImageIcon logo = new ImageIcon("FondoTienda.png");
            fondoMain.setBounds(0, 0, 1500, 1000);
            fondoMain.setIcon(new ImageIcon(logo.getImage().getScaledInstance(1500, 1000, Image.SCALE_SMOOTH)));

            Categoria.addActionListener(descubrirCategorias);

            mainTienda.add(Logo);
            mainTienda.add(Categoria);

            //-----------------------------------------------------------------------

            Ropa ropa = new Ropa(); // Utilizar este mostrar() para la ropa en oferta

            String[] aux = ropa.mostrar();

            int p = 350;
            int q =350;
            int ancho = 150;
            int alto = 150;

            for(String ruta: aux){
                ImageIcon icono = new ImageIcon(ruta);
                JLabel etiquetaImagen = new JLabel(icono);
                etiquetaImagen.setBounds(p,q,ancho,alto);
                etiquetaImagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

                p+=200;

                mainTienda.add(etiquetaImagen);
            }

            //----------------------------------------------------------------------------

            if(x){
                JButton anyadir = new JButton("añadir prenda");
                JButton eliminiar = new JButton("eliminar prenda");

                anyadir.setBounds(0,215,130,30);
                eliminiar.setBounds(150,215,130,30);

                anyadir.addActionListener(aniadir);

                mainTienda.add(anyadir);
                mainTienda.add(eliminiar);
            }

            mainTienda.add(fondoMain);

            ventanaTienda.setVisible(true);
            ventanaTienda.setSize(1500, 1000);
            ventanaTienda.setLocationRelativeTo(null);
            ventanaTienda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ventanaTienda.add(mainTienda);
        }

        ActionListener aniadir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame ventanaImagen = new JFrame();
                JPanel panel = new JPanel();

                panel.setLayout(null);

                JLabel imagen = new JLabel("Escribe el nombre de la imagen");
                imagen.setBounds(10,10,300,30);

                nombreImagen = new JTextField();
                nombreImagen.setBounds(10,80,150,30);

                JButton guardarImagen = new JButton("Guardar");
                guardarImagen.setBounds(110,120,80,30);

                panel.add(imagen);
                panel.add(guardarImagen);
                panel.add(nombreImagen);

                guardarImagen.addActionListener(guardar);

                ventanaImagen.setVisible(true);
                ventanaImagen.setSize(300,300);
                ventanaImagen.setLocationRelativeTo(null);
                ventanaImagen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                ventanaImagen.add(panel);

            }
        };

    ActionListener guardar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Ropa x = new Ropa();
            x.guardarImagen(nombreImagen);
        }
    };

    ActionListener descubrirCategorias = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Categorias x = new Categorias(mainTienda,ventanaTienda);
        }
    };

}
