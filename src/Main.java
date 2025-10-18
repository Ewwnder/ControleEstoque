
import dao.ConexaoBD;
import java.sql.Connection;

/**
 *
 * @author Nicolas Ap
 */
public class Main {
    public static void main(String[] args) {
        
        try (Connection conn = ConexaoBD.getConnection()){
            System.out.println("Conectado com sucesso ao banco!");
        } catch (Exception e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
    
}
