package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nicolas Ap
 */
public class ConexaoBD {
    
    private static final String url = "jdbc:mysql://localhost:3306/controle_estoque";
    private static final String user = "root";
    private static final String password = "";
    
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.err.println("Erro ao conectar com o banco: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
