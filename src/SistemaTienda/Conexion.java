package SistemaTienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion{
    Connection con;

    public Connection getConnection() {
        try {
            String BD = "jdbc:mysql://localhost:3306/abc?serverTimezone=UTC";
            con = DriverManager.getConnection(BD, "root", "");
            return con;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
