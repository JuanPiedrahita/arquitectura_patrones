
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    private static Connection conexion = null;
    private ConexionDB(){}

    public static Connection getConexion()  {
        if (ConexionDB.conexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexion = DriverManager.getConnection("jdbc:mysql://localhost/basedatosjsj", "root", "");
                System.out.println("Conexion realizada");
                return conexion;
            } catch (Exception e) {
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
            }

        } else {
            return conexion;
        }
        return conexion;
    }
}
