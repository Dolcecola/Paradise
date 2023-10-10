package SistemaTienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrearCuenta {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;

    public boolean RegistrarUsuario(Login c) {
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
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error");
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("error sql");
            }
        }
    }
}
