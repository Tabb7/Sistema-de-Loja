package stockmanager_database;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class conexao {
    
   
    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL não encontrado no projeto!", e);
        }
        
        String url = "jdbc:postgresql://localhost:5432/banco_loja_rafael_e_arthur";
        String user = "postgres";
        String password = "1234"; 
        return DriverManager.getConnection(url, user, password);
    }
}
