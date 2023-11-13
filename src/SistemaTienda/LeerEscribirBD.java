package SistemaTienda;

import javax.swing.*;
import java.sql.*;

public class LeerEscribirBD {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Cliente log(String nombre, String pass){

        Cliente l = new Cliente();
        String sql = "SELECT * FROM login WHERE usuario = ? AND password = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            if (rs.next()) {
                l.setNombre(rs.getString("nombre"));
                l.setPass(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    public void RegistrarUsuario(Cliente c) {
        String sql = "INSERT INTO login (usuario, password, nombre, apellidos, email, telefono) VALUES (?,?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getUsuario());
            ps.setString(2, c.getPass());
            ps.setString(3, c.getNombre());
            ps.setString(4, c.getApellidos());
            ps.setString(5, c.getEmail());
            ps.setInt(6, c.getTelefono());
            ps.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("error sql");
            }
        }
    }
    public Admin leerAdmin(String nombre, String pass){

        Admin l = new Admin();
        String sql = "SELECT * FROM admins WHERE usuario = ? AND password = ?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            if (rs.next()) {
                l.setNombre(rs.getString("usuario"));
                l.setPass(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return l;
    }
    public String[][] leerImagen(){
        String sql = "SELECT * FROM ropa";

        String[][] vec =  new String[2][6];

        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            int i=0;
            while(rs.next()){

                for(int j=0;j<6;j++){
                    int z=j+1;
                    vec[i][j] = rs.getString(z);
                }

                i++;
            }

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return(vec);
    }
    public void escribirImagen(Ropa r){
        String sql = "INSERT INTO ropa (imagen) VALUES (?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, r.getNombreImagen());
            ps.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("error sql");
            }
        }
    }
}
