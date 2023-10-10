package SistemaTienda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Login log(String nombre, String pass) {
        Login l = new Login();
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
}
