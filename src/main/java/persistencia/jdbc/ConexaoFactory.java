package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by claud on 20/05/2017.
 */
public class ConexaoFactory {

    private static Connection connection;
    public static Connection getConnection() {
        String url = "dao:postgresql://localhost:5432/testejeradb";
        String usuario = "postgres";
        String senha = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            if (connection==null){
                connection =  DriverManager.getConnection(url, usuario, senha);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
