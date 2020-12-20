

package folha.aconexao.br.com.banco.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    
    // Conexao com postgres
    
    public static Connection getConnection() throws SQLException {
    
    try {
        Class.forName ("org.postgresql.Driver");               // caminho / nome do banco / usuario / senha
        return DriverManager.getConnection ("jdbc:postgresql://localhost:5432/folha",
                  "postgres",
                  "191");
            } catch (ClassNotFoundException e){
                
                throw new SQLException (e.getMessage());
                
            }
    
}    
 
    
    
    



}
