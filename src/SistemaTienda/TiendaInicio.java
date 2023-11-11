package SistemaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TiendaInicio {
    private JPanel mainPanel;
    private JLabel imagenFondo;
    private JFrame ventana;
    private JButton inicioS;
    private JButton crear;
    private JTextField usuario;
    private JTextField password;

    public TiendaInicio(){
        InitComponents();
    }

    public void InitComponents(){
        ventana = new JFrame("Nombre");
        mainPanel = new JPanel();
        imagenFondo = new JLabel();
        Color f = new Color(219, 216, 227);

        crear = new JButton();
        crear.setText("crear cuenta");
        crear.setBounds(558, 255, 120, 30);
        crear.setHorizontalAlignment(SwingConstants.CENTER);
        crear.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        inicioS = new JButton();
        inicioS.setText("acceder");
        inicioS.setBounds(430, 255, 90, 30);
        inicioS.setHorizontalAlignment(SwingConstants.CENTER);
        inicioS.setFont(new Font("Times New Roman", Font.PLAIN, 14));

        JLabel nombre = new JLabel();
        nombre.setText("Usuario");
        nombre.setBounds(310, 155, 150, 30);
        nombre.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        password = new JTextField();
        password.setBounds(430, 200, 250, 28);

        JLabel cont = new JLabel();
        cont.setText("Contraseña");
        cont.setBounds(295, 200, 150, 30);
        cont.setHorizontalAlignment(SwingConstants.CENTER);
        cont.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        usuario = new JTextField();
        usuario.setBounds(430, 155, 250, 28);

        JLabel login = new JLabel();
        login.setText("Iniciar Sesión");
        login.setBounds(450, 10, 200, 200);
        login.setHorizontalAlignment(SwingConstants.CENTER);
        login.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        //Color f = new Color(235, 236, 218);

        mainPanel.setLayout(null);
        mainPanel.setBackground(f);

        ImageIcon logo = new ImageIcon("logo2.png");
        imagenFondo.setBounds(0, 50, 350, 300);
        imagenFondo.setIcon(new ImageIcon(logo.getImage().getScaledInstance(350, 300, Image.SCALE_SMOOTH)));

        mainPanel.add(crear);
        mainPanel.add(inicioS);
        mainPanel.add(password);
        mainPanel.add(cont);
        mainPanel.add(nombre);
        mainPanel.add(usuario);
        mainPanel.add(login);
        mainPanel.add(imagenFondo);

        ventana.setSize(800, 500);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        crear.addActionListener(CrearCuenta);
        inicioS.addActionListener(acceder);

        ventana.add(mainPanel);

    }

    ActionListener acceder = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            Cliente c = new Cliente();

            if(c.validar(usuario,password)){

                ventana.dispose();
                TiendaMain x = new TiendaMain(false);
            }
        }
    };

    ActionListener CrearCuenta = new ActionListener() {
        public void actionPerformed(ActionEvent f) {

            ventana.dispose();
            TiendaCuenta x = new TiendaCuenta();
        }
    };
}
