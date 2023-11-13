package SistemaTienda;

import javax.swing.*;
import javax.xml.catalog.Catalog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * Esta clase se encarga de crear la ventana principal de la tienda online.
 *
 */

public class TiendaMain extends JFrame{
    int p = 350;
    int q = 350;
    int ancho = 150;
    int alto = 150;
    int coordY = 255;
    private JLayeredPane mainTienda = new JLayeredPane();
    private JTextField nombreImagen;
    private JButton hombre;
    private JButton mujer;
    private JButton camisetas;
    private JButton pantalones;
    private JButton zapatos;

    public TiendaMain(boolean x){
        tienda(x);
    }
        public void tienda(boolean x){

            botones();
            fondo();

            JLabel Logo = new JLabel();

            Logo.setText("MSB");
            Logo.setBounds(700, 100, 150, 30);
            Logo.setHorizontalAlignment(SwingConstants.CENTER);
            Logo.setFont(new Font("Times New Roman", Font.PLAIN, 20));

            mainTienda.add(Logo, JLayeredPane.PALETTE_LAYER);

            //-----------------------------------------------------------------------

            /*Ropa ropa = new Ropa(); // Utilizar este mostrar() para la ropa en oferta

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

                mainTienda.add(etiquetaImagen, JLayeredPane.DEFAULT_LAYER);
            }*/

            //----------------------------------------------------------------------------

            if(x){
                JButton anyadir = new JButton("añadir prenda");
                JButton eliminiar = new JButton("eliminar prenda");

                anyadir.setBounds(0,215,130,30);
                eliminiar.setBounds(150,215,130,30);

                anyadir.addActionListener(aniadir);

                mainTienda.add(anyadir, JLayeredPane.PALETTE_LAYER);
                mainTienda.add(eliminiar, JLayeredPane.PALETTE_LAYER);
            }

            setVisible(true);
            setSize(1500, 1000);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            add(mainTienda);
        }

        private void fondo(){

            ImageIcon logo = new ImageIcon("FondoTienda.png");
            JLabel miFondo = new JLabel();
            miFondo.setBounds(0, 0, 1500, 1000);
            miFondo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(1500, 1000, Image.SCALE_SMOOTH)));

            mainTienda.add(miFondo, JLayeredPane.DEFAULT_LAYER);
        }


    private void botones(){
        JButton categoria = new JButton("Categorias");

        categoria.setBounds(0, 255, 310, 30);
        categoria.setBackground(Color.gray);

        categoria.addActionListener(descubrirCategorias);

        mainTienda.add(categoria, JLayeredPane.PALETTE_LAYER);

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

            eliminarBotonesAdicionales();

            hombre = new JButton("hombre");
            mujer = new JButton("mujer");

            hombre.setBounds(0,coordY+30,310,30);
            mujer.setBounds(0,coordY+60,310,30);

            hombre.addActionListener(descubrirHombre);
            mujer.addActionListener(descubrirMujer);

            mainTienda.add(hombre, JLayeredPane.PALETTE_LAYER);
            mainTienda.add(mujer, JLayeredPane.PALETTE_LAYER);
            mainTienda.revalidate();
            mainTienda.repaint();
        }
    };

    ActionListener descubrirHombre = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            eliminarHombre();

            camisetas = new JButton("camisetas");
            pantalones = new JButton("pantalones");
            zapatos = new JButton("zapatos");

            camisetas.setBounds(0,coordY+60,310,30);
            pantalones.setBounds(0,coordY+90,310,30);
            zapatos.setBounds(0,coordY+120,310,30);

            camisetas.addActionListener(camisetaHombre);

            mainTienda.add(camisetas, JLayeredPane.PALETTE_LAYER);
            mainTienda.add(pantalones, JLayeredPane.PALETTE_LAYER);
            mainTienda.add(zapatos, JLayeredPane.PALETTE_LAYER);
            mainTienda.revalidate();
            mainTienda.repaint();
        }
    };

        ActionListener camisetaHombre = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            Ropa ropa = new Ropa();
            String[][] aux = ropa.infoImagenes();

            for(int i=0;i<2;i++){
                if(aux[i][1].equals("hombre") && aux[i][2].equals("camiseta")){

                    String ruta = aux[i][0];

                    ImageIcon icono = new ImageIcon(ruta);
                    JLabel etiquetaImagen = new JLabel(icono);
                    etiquetaImagen.setName("borrar");
                    etiquetaImagen.setBounds(p,q,ancho,alto);
                    etiquetaImagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

                    int indice = i;
                    etiquetaImagen.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            eliminarOtrasEtiquetas(aux, indice);
                        }
                    });

                    p+=200;

                    mainTienda.add(etiquetaImagen, JLayeredPane.PALETTE_LAYER);

                }
            }
            mainTienda.revalidate();
            mainTienda.repaint();
        }
    };

    ActionListener descubrirMujer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            eliminarMujer();

            mujer.setBounds(0,coordY+30,310,30);

            camisetas = new JButton("camisetas");
            pantalones = new JButton("pantalones");
            zapatos = new JButton("zapatos");

            camisetas.setBounds(0,coordY+60,310,30);
            pantalones.setBounds(0,coordY+90,310,30);
            zapatos.setBounds(0,coordY+120,310,30);

            camisetas.addActionListener(camisetaMujer);

            mainTienda.add(camisetas, JLayeredPane.PALETTE_LAYER);
            mainTienda.add(pantalones, JLayeredPane.PALETTE_LAYER);
            mainTienda.add(zapatos, JLayeredPane.PALETTE_LAYER);
            mainTienda.revalidate();
            mainTienda.repaint();
        }
    };
        ActionListener camisetaMujer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Component[] componentes = mainTienda.getComponents();
                for (Component componente : componentes) {
                    if (componente instanceof JLabel) {

                        JLabel etiqueta = (JLabel) componente;

                        if (etiqueta.getName() != null && etiqueta.getName().equals("borrar")) {
                            mainTienda.remove(componente);
                        }
                    }
                }
                mainTienda.revalidate();
                mainTienda.repaint();
            }
        };

    private void eliminarOtrasEtiquetas(String[][] aux, int indice){
        Component[] componentes = mainTienda.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JLabel) {

                JLabel etiqueta = (JLabel) componente;

                if (etiqueta.getName() != null && etiqueta.getName().equals("borrar")) {
                    mainTienda.remove(componente);
                }
            }
        }

        String ruta = aux[indice][0];

        ImageIcon icono = new ImageIcon(ruta);
        JLabel etiquetaImagen = new JLabel(icono);
        etiquetaImagen.setBounds(p,q,ancho+150,alto+150);
        etiquetaImagen.setName("borrar");
        etiquetaImagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(ancho+150, alto+150, Image.SCALE_SMOOTH)));

        mainTienda.add(etiquetaImagen,JLayeredPane.PALETTE_LAYER);

        mainTienda.revalidate();
        mainTienda.repaint();
    }

    private void eliminarBotonesAdicionales() {

        if(hombre!=null){
            mainTienda.remove(hombre);
        }

        if(mujer!=null){
            mainTienda.remove(mujer);
        }

        if (camisetas != null || pantalones!=null || zapatos!=null) {
            mainTienda.remove(camisetas);
            mainTienda.remove(pantalones);
            mainTienda.remove(zapatos);
        }

    }
    private void eliminarHombre(){
        if(mujer!=null){
            mainTienda.remove(mujer);
        }

        if (camisetas != null || pantalones!=null || zapatos!=null) {
            mainTienda.remove(camisetas);
            mainTienda.remove(pantalones);
            mainTienda.remove(zapatos);
        }
    }
    private void eliminarMujer(){
        if(hombre!=null){
            mainTienda.remove(hombre);
        }

        if (camisetas != null || pantalones!=null || zapatos!=null) {
            mainTienda.remove(camisetas);
            mainTienda.remove(pantalones);
            mainTienda.remove(zapatos);
        }
    }
}
