import java.sql.*;

public class Conexion1{

    static String URL= System.getenv("url");
    static String USER =System.getenv("user");
    static String PASS = System.getenv("password");

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
        Statement stmt = conn.createStatement();
        ResultSet rs=null;)
        {
            System.out.println("Conectado");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No conectado");
        }
    }

}
