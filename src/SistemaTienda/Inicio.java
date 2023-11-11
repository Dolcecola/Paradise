package SistemaTienda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio{

    private JFrame ventana;
    private JPanel panel;
    private JRadioButton botonUsuario;
    private JRadioButton botonAdmin;
    private JButton cambio;
    public Inicio(){
        ventanaInicio();
    }

    public void ventanaInicio(){

        ventana = new JFrame();
        panel = new JPanel();
        Color f = new Color(219, 216, 227);

        botonUsuario = new JRadioButton("Usuario");
        botonUsuario.setBounds(10,10,70,30);
        botonUsuario.setBackground(f);

        botonAdmin = new JRadioButton("Admin",true);
        botonAdmin.setBounds(10,50,60,30);
        botonAdmin.setBackground(f);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(botonUsuario);
        grupo.add(botonAdmin);

        cambio = new JButton("Entrar");
        cambio.setBounds(100,100,100,30);

        panel.setLayout(null);
        panel.setBackground(f);

        panel.add(botonUsuario);
        panel.add(botonAdmin);
        panel.add(cambio);

        ventana.setSize(300, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        cambio.addActionListener(entrar);

        ventana.add(panel);

    }

    ActionListener entrar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(botonUsuario.isSelected()){
                ventana.dispose();
                TiendaInicio x = new TiendaInicio();
            }else{
                ventana.dispose();
                TiendaInicioAdmin x = new TiendaInicioAdmin();
            }
        }
    };
}
